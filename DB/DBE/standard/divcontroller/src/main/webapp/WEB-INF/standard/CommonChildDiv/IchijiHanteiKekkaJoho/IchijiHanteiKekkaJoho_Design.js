var DBE;
(function (DBE) {
    (function (IchijiHanteiKekkaJoho) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        IchijiHanteiKekkaJoho.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "IchijiHanteiKekkaJoho";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.IchijiHanteiKekkaJoho.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.IchijiHanteiKekkaJoho.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.IchijiHanteiKekkaJoho = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnModoru = function () {
                return new UZA.Button(this.convFiledName("btnModoru"));
            };
            return Controls;
        })();
        IchijiHanteiKekkaJoho.Controls = Controls;
    })(DBE.IchijiHanteiKekkaJoho || (DBE.IchijiHanteiKekkaJoho = {}));
    var IchijiHanteiKekkaJoho = DBE.IchijiHanteiKekkaJoho;
})(DBE || (DBE = {}));
