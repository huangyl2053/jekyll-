/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbz100001;

import jp.co.ndensan.reams.db.dbb.business.report.dbb021051.DBZ100001AtenaSealParameterEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.atenaseal.DBZ100001AtenaSealSource;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 帳票設計_DBZ100001_宛名シールBodyEditor
 *
 * @reamsid_L DBB-5660-040 jiangxiaolong
 */
public class AtenaSealEditor
        implements IAtenaSealEditor {

    private final DBZ100001AtenaSealParameterEntity entity;
    private static final RString 宛名シール = new RString("宛名シール");
    private static final RString SAKUSEI = new RString("作成");

    /**
     * コンストラクタです
     *
     * @param parameter DBZ100001AtenaSealParameterEntity
     */
    public AtenaSealEditor(
            DBZ100001AtenaSealParameterEntity parameter) {
        this.entity = parameter;

    }

    @Override
    public DBZ100001AtenaSealSource edit(
            DBZ100001AtenaSealSource source) {
        editSource(source);
        return source;
    }

    private void editSource(DBZ100001AtenaSealSource source) {
        if (null == entity) {
            return;
        }
        YMDHMS 作成日時 = YMDHMS.now();
        RString 作成日 = 作成日時.getRDateTime().getDate().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 作成時 = 作成日時.getRDateTime().getTime()
                .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE).concat(SAKUSEI);
        source.printTimeStamp = 作成日.concat(RString.HALF_SPACE).concat(作成時);
        source.shichosonCode = entity.get市町村コード();
        source.shichosonName = entity.get市町村名称();
        source.title = 宛名シール;
//        source.yubinNo = entity.get郵便番号();
//        source.gyoseiku = entity.get行政区();
//        source.jushoText = entity.get住所TXT();
//        source.katagakiSmall2 = entity.get方書2();
//        source.katagakiSmall1 = entity.get方書1();
//        source.dainoKubunMei = entity.get代納区分名称();
//        source.shimeiSmall2 = entity.get氏名2();
//        source.shimeiSmall1 = entity.get氏名1();
//        source.samabunShimeiSmall2 = entity.get様分氏名2();
//        source.samabunShimeiSmall1 = entity.get様分氏名1();
//        source.kakkoLeft2 = entity.get左括号2();
//        source.kakkoLeft1 = entity.get左括号1();
//        source.meishoFuyo2 = entity.get名称付与2();
//        source.meishoFuyo1 = entity.get名称付与1();
//        source.samaBun2 = entity.get様分2();
//        source.samaBun1 = entity.get様分1();
//        source.kakkoRight2 = entity.get右括号2();
//        source.kakkoRight1 = entity.get右括号1();
//        source.customerBarCode = entity.getバーコード住所();

    }

}
