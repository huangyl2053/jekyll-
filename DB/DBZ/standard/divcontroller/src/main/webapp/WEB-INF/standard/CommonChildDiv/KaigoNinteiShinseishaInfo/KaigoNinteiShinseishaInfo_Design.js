var DBZ;
(function (DBZ) {
    (function (KaigoNinteiShinseishaInfo) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KaigoNinteiShinseishaInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoNinteiShinseishaInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KaigoNinteiShinseishaInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KaigoNinteiShinseishaInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoNinteiShinseishaInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ccdKaigoNinteiAtenaInfo = function () {
                return new DBZ.KaigoNinteiAtenaInfo.ModeController(this.convFiledName("ccdKaigoNinteiAtenaInfo"));
            };

            Controls.prototype.ccdKaigoShikakuKihon = function () {
                return new DBZ.KaigoShikakuKihon.ModeController(this.convFiledName("ccdKaigoShikakuKihon"));
            };
            return Controls;
        })();
        KaigoNinteiShinseishaInfo.Controls = Controls;
    })(DBZ.KaigoNinteiShinseishaInfo || (DBZ.KaigoNinteiShinseishaInfo = {}));
    var KaigoNinteiShinseishaInfo = DBZ.KaigoNinteiShinseishaInfo;
})(DBZ || (DBZ = {}));
