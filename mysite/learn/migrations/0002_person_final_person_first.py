# -*- coding: utf-8 -*-
# Generated by Django 1.11.8 on 2018-01-05 09:25
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('learn', '0001_initial'),
    ]

    operations = [
        migrations.CreateModel(
            name='person_final',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('athletes_id', models.CharField(max_length=30)),
                ('event_type', models.CharField(max_length=30)),
                ('total_score', models.IntegerField()),
                ('athletes_sex', models.IntegerField()),
                ('team_type', models.IntegerField()),
            ],
        ),
        migrations.CreateModel(
            name='person_first',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('athletes_id', models.CharField(max_length=30)),
                ('event_type', models.CharField(max_length=30)),
                ('total_score', models.IntegerField()),
                ('athletes_sex', models.IntegerField()),
                ('team_type', models.IntegerField()),
            ],
        ),
    ]
