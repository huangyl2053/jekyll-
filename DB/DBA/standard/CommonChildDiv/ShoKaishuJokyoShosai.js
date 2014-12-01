var DBA;
(function (DBA) {
    (function (ShoKaishuJokyoShosai) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShoKaishuJokyoShosai.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        ShoKaishuJokyoShosai.ModeController = ModeController;
    })(DBA.ShoKaishuJokyoShosai || (DBA.ShoKaishuJokyoShosai = {}));
    var ShoKaishuJokyoShosai = DBA.ShoKaishuJokyoShosai;
})(DBA || (DBA = {}));
