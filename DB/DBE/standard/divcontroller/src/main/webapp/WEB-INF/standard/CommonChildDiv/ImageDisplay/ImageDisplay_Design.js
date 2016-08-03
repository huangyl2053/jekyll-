var DBE;
(function (DBE) {
    (function (ImageDisplay) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnBefore = function () {
                return "onClick_btnBefore";
            };

            Events.onClick_btnBack = function () {
                return "onClick_btnBack";
            };

            Events.onClick_btnAfterImg = function () {
                return "onClick_btnAfterImg";
            };
            return Events;
        })();
        ImageDisplay.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ImageDisplay";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.ImageDisplay.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.ImageDisplay.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ImageDisplay = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.lblGenbon = function () {
                return new UZA.Label(this.convFiledName("lblGenbon"));
            };

            Controls.prototype.imgGenbon = function () {
                return new UZA.StaticImage(this.convFiledName("imgGenbon"));
            };

            Controls.prototype.lblMask = function () {
                return new UZA.Label(this.convFiledName("lblMask"));
            };

            Controls.prototype.imgMask = function () {
                return new UZA.StaticImage(this.convFiledName("imgMask"));
            };

            Controls.prototype.btnBefore = function () {
                return new UZA.Button(this.convFiledName("btnBefore"));
            };

            Controls.prototype.btnBack = function () {
                return new UZA.Button(this.convFiledName("btnBack"));
            };

            Controls.prototype.btnAfterImg = function () {
                return new UZA.Button(this.convFiledName("btnAfterImg"));
            };
            return Controls;
        })();
        ImageDisplay.Controls = Controls;
    })(DBE.ImageDisplay || (DBE.ImageDisplay = {}));
    var ImageDisplay = DBE.ImageDisplay;
})(DBE || (DBE = {}));
