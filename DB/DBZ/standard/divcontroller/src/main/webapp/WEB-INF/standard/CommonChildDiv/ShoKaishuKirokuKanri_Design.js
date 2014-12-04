var DBZ;
(function (DBZ) {
    (function (ShoKaishuKirokuKanri) {
        var Events = (function () {
            function Events() {
            }
            Events.onBeforeClick_btnShoKaishuKakutei = function () {
                return "onBeforeClick_btnShoKaishuKakutei";
            };

            Events.onClick_btnShoKaishuKakutei = function () {
                return "onClick_btnShoKaishuKakutei";
            };

            Events.onClick_btnShoKaishuTorikeshi = function () {
                return "onClick_btnShoKaishuTorikeshi";
            };
            return Events;
        })();
        ShoKaishuKirokuKanri.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShoKaishuKirokuKanri";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ShoKaishuKirokuKanri.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShoKaishuKirokuKanri.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShoKaishuKirokuKanri = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ccdShoKaishuJokyoList = function () {
                return new DBZ.ShoKaishuJokyoList.ModeController(this.convFiledName("ccdShoKaishuJokyoList"));
            };

            Controls.prototype.ccdShoKaishuJokyoShosai = function () {
                return new DBZ.ShoKaishuJokyoShosai.ModeController(this.convFiledName("ccdShoKaishuJokyoShosai"));
            };

            Controls.prototype.btnShoKaishuKakutei = function () {
                return new UZA.Button(this.convFiledName("btnShoKaishuKakutei"));
            };

            Controls.prototype.btnShoKaishuTorikeshi = function () {
                return new UZA.Button(this.convFiledName("btnShoKaishuTorikeshi"));
            };
            return Controls;
        })();
        ShoKaishuKirokuKanri.Controls = Controls;
    })(DBZ.ShoKaishuKirokuKanri || (DBZ.ShoKaishuKirokuKanri = {}));
    var ShoKaishuKirokuKanri = DBZ.ShoKaishuKirokuKanri;
})(DBZ || (DBZ = {}));
