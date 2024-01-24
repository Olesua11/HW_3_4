package com.example.hw_3_4.ui.notifications

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bumptech.glide.Glide
import com.example.hw_3_4.databinding.ItemOnboardingBinding

class OnBoardingAdapter(private val onClick: () -> Unit) :
    RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {
    private val list = arrayListOf<onBording>(
        onBording("Добро пожаловать в Task Manager!", "Удобный инструмент для управления задачами и повышения производительности.", "https://dspncdn.com/a1/media/originals/6f/f3/51/6ff35161e8ddf3b77a089c434953e83c.jpg"),
        onBording("Основные возможности приложения", "Создавайте задачи и проекты.\n" +
                "Устанавливайте сроки и приоритеты.\n" +
                "Отмечайте задачи как выполненные.\n" +
                "Просматривайте статистику производительности.", "https://www.playmeo.com/wp-content/uploads/2021/06/Planning-Board-for-sequencing-programs-shutterstock_615691754.png"),
        onBording("Как вам поможет Task Manager?", "Увеличьте свою эффективность.\n" +
                "Никогда не забудьте о важных задачах.\n" +
                "Организуйте свои проекты более эффективно.", "https://www.pinclipart.com/picdir/big/409-4092024_get-started-for-free-clipart.png")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnboardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnboardingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(onBoarding: onBording) = with(binding) {
            tvTitle.text = onBoarding.title
            tvDesc.text = onBoarding.desc
            tvSkip.isVisible = adapterPosition != list.lastIndex
            btnGetStarted.isVisible = adapterPosition == list.lastIndex
            Glide.with(binding.ivBoard).load(onBoarding.image.toString()
            ).into(binding.ivBoard)

            btnGetStarted.setOnClickListener {
                onClick()
            }
            tvSkip.setOnClickListener {
                onClick()
            }

        }


    }

}
