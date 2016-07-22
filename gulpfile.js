"use strict";

var gulp = require('gulp'),
    rename = require("gulp-rename"),
    autoprefixer = require('gulp-autoprefixer'),
    uncss = require('gulp-uncss'),
    sass = require('gulp-sass'),
    cleanCSS = require('gulp-clean-css'),
    concat = require('gulp-concat'),
    uglify = require('gulp-uglify');


gulp.task('sass', function () {
    gulp.src('web/src/sass/import.scss')
        .pipe(sass().on('error', sass.logError))
        .pipe(autoprefixer({ browsers: ['> 1%', 'IE 7'], cascade: false }))
        .pipe(cleanCSS({compatibility: ''}))
        .pipe(rename('style.min.css'))
        .pipe(gulp.dest('web/assets/css'));
});

gulp.task('bootstrap', function () {
    gulp.src('web/src/sass/bootstrap.scss')
        .pipe(sass().on('error', sass.logError))
        .pipe(autoprefixer({ browsers: ['> 1%', 'IE 7'], cascade: false }))
        .pipe(cleanCSS({compatibility: ''}))
        .pipe(rename('bootstrap.min.css'))
        .pipe(gulp.dest('web/assets/css'));
});

gulp.task('scripts', function() {
    return gulp.src(['web/src/js/*.js'])
        .pipe(concat('main.min.js'))
        .pipe(uglify())
        .pipe(gulp.dest('web/assets/js'));
});

gulp.task('watch', function () {
    gulp.watch('web/src/sass/**/*.scss', ['sass']);
    gulp.watch('web/src/js/**/*.js', ['scripts']);
    gulp.watch('web/src/sass/bootstrap/**/*.scss', ['bootstrap']);
});

gulp.task('default', ['sass','bootstrap', 'scripts', 'watch']);