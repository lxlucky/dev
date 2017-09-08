key: "init",
					value: function() {
						var t = this;
						this.dom = {
							cover: this.root.querySelector(".skPlayer-cover"),
							playbutton: this.root.querySelector(".skPlayer-play-btn"),
							name: this.root.querySelector(".skPlayer-name"),
							author: this.root.querySelector(".skPlayer-author"),
							timeline_total: this.root.querySelector(".skPlayer-percent"),
							timeline_loaded: this.root.querySelector(".skPlayer-line-loading"),
							timeline_played: this.root.querySelector(".skPlayer-percent .skPlayer-line"),
							timetext_total: this.root.querySelector(".skPlayer-total"),
							timetext_played: this.root.querySelector(".skPlayer-cur"),
							volumebutton: this.root.querySelector(".skPlayer-icon"),
							volumeline_total: this.root.querySelector(".skPlayer-volume .skPlayer-percent"),
							volumeline_value: this.root.querySelector(".skPlayer-volume .skPlayer-line"),
							switchbutton: this.root.querySelector(".skPlayer-list-switch"),
							modebutton: this.root.querySelector(".skPlayer-mode"),
							musiclist: this.root.querySelector(".skPlayer-list"),
							musicitem: this.root.querySelectorAll(".skPlayer-list li")
						}, this.audio = this.root.querySelector(".skPlayer-source"), this.option.listshow && (this.root.className = "skPlayer-list-on"), "singleloop" === this.option.mode && (this.audio.loop = !0), this.dom.musicitem[0].className = "skPlayer-curMusic", "cloud" === this.type && s.ajax({
							url: a + "song/detail?id=" + this.music[0].song_id,
							beforeSend: function() {
								console.log("SKPlayer正在努力的拉取歌曲 ...")
							},
							success: function(e) {
								console.log("歌曲拉取成功！");
								var n = JSON.parse(e).url;
								t.audio.src = n
							},
							fail: function(t) {
								console.error("歌曲拉取失败！ 错误码：" + t)
							}
						})
					}