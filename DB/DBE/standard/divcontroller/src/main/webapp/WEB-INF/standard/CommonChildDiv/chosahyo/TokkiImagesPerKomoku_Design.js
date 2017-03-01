var DBE;
(function (DBE) {
    (function (TokkiImagesPerKomoku) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        TokkiImagesPerKomoku.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "TokkiImagesPerKomoku";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.TokkiImagesPerKomoku.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.TokkiImagesPerKomoku.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.TokkiImagesPerKomoku = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtNo1 = function () {
                return new UZA.TextBox(this.convFiledName("txtNo1"));
            };

            Controls.prototype.txtRemban1 = function () {
                return new UZA.TextBox(this.convFiledName("txtRemban1"));
            };

            Controls.prototype.imgTokki1 = function () {
                return new UZA.DynamicImage(this.convFiledName("imgTokki1"));
            };

            Controls.prototype.txtNewRemban1 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtNewRemban1"));
            };

            Controls.prototype.txtNo2 = function () {
                return new UZA.TextBox(this.convFiledName("txtNo2"));
            };

            Controls.prototype.txtRemban2 = function () {
                return new UZA.TextBox(this.convFiledName("txtRemban2"));
            };

            Controls.prototype.imgTokki2 = function () {
                return new UZA.DynamicImage(this.convFiledName("imgTokki2"));
            };

            Controls.prototype.txtNewRemban2 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtNewRemban2"));
            };

            Controls.prototype.txtNo3 = function () {
                return new UZA.TextBox(this.convFiledName("txtNo3"));
            };

            Controls.prototype.txtRemban3 = function () {
                return new UZA.TextBox(this.convFiledName("txtRemban3"));
            };

            Controls.prototype.imgTokki3 = function () {
                return new UZA.DynamicImage(this.convFiledName("imgTokki3"));
            };

            Controls.prototype.txtNewRemban3 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtNewRemban3"));
            };

            Controls.prototype.txtNo4 = function () {
                return new UZA.TextBox(this.convFiledName("txtNo4"));
            };

            Controls.prototype.txtRemban4 = function () {
                return new UZA.TextBox(this.convFiledName("txtRemban4"));
            };

            Controls.prototype.imgTokki4 = function () {
                return new UZA.DynamicImage(this.convFiledName("imgTokki4"));
            };

            Controls.prototype.txtNewRemban4 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtNewRemban4"));
            };

            Controls.prototype.txtNo5 = function () {
                return new UZA.TextBox(this.convFiledName("txtNo5"));
            };

            Controls.prototype.txtRemban5 = function () {
                return new UZA.TextBox(this.convFiledName("txtRemban5"));
            };

            Controls.prototype.imgTokki5 = function () {
                return new UZA.DynamicImage(this.convFiledName("imgTokki5"));
            };

            Controls.prototype.txtNewRemban5 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtNewRemban5"));
            };

            Controls.prototype.txtNo6 = function () {
                return new UZA.TextBox(this.convFiledName("txtNo6"));
            };

            Controls.prototype.txtRemban6 = function () {
                return new UZA.TextBox(this.convFiledName("txtRemban6"));
            };

            Controls.prototype.imgTokki6 = function () {
                return new UZA.DynamicImage(this.convFiledName("imgTokki6"));
            };

            Controls.prototype.txtNewRemban6 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtNewRemban6"));
            };

            Controls.prototype.txtNo7 = function () {
                return new UZA.TextBox(this.convFiledName("txtNo7"));
            };

            Controls.prototype.txtRemban7 = function () {
                return new UZA.TextBox(this.convFiledName("txtRemban7"));
            };

            Controls.prototype.imgTokki7 = function () {
                return new UZA.DynamicImage(this.convFiledName("imgTokki7"));
            };

            Controls.prototype.txtNewRemban7 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtNewRemban7"));
            };

            Controls.prototype.txtNo8 = function () {
                return new UZA.TextBox(this.convFiledName("txtNo8"));
            };

            Controls.prototype.txtRemban8 = function () {
                return new UZA.TextBox(this.convFiledName("txtRemban8"));
            };

            Controls.prototype.imgTokki8 = function () {
                return new UZA.DynamicImage(this.convFiledName("imgTokki8"));
            };

            Controls.prototype.txtNewRemban8 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtNewRemban8"));
            };

            Controls.prototype.txtNo9 = function () {
                return new UZA.TextBox(this.convFiledName("txtNo9"));
            };

            Controls.prototype.txtRemban9 = function () {
                return new UZA.TextBox(this.convFiledName("txtRemban9"));
            };

            Controls.prototype.imgTokki9 = function () {
                return new UZA.DynamicImage(this.convFiledName("imgTokki9"));
            };

            Controls.prototype.txtNewRemban9 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtNewRemban9"));
            };
            return Controls;
        })();
        TokkiImagesPerKomoku.Controls = Controls;
    })(DBE.TokkiImagesPerKomoku || (DBE.TokkiImagesPerKomoku = {}));
    var TokkiImagesPerKomoku = DBE.TokkiImagesPerKomoku;
})(DBE || (DBE = {}));
