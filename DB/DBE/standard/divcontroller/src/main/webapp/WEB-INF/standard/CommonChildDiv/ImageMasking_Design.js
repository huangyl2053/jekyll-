var DBE;
(function (DBE) {
    (function (ImageMasking) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ImageMasking.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ImageMasking";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.ImageMasking.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.ImageMasking.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ImageMasking = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };
            return Controls;
        })();
        ImageMasking.Controls = Controls;
    })(DBE.ImageMasking || (DBE.ImageMasking = {}));
    var ImageMasking = DBE.ImageMasking;
})(DBE || (DBE = {}));
