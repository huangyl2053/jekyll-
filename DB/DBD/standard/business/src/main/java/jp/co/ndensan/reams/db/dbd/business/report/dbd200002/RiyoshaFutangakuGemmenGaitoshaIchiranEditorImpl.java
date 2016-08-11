/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200002;

import java.text.SimpleDateFormat;
import java.util.Date;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt00002.ChohyoShutsuryokuJohoShutokuResultEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd00002.RiyoshaFutangakuGemmenGaitoshaIchiranReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.IYokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 利用負担額減額免除認定証Editorのクラスです。
 *
 * @reamsid_L DBD-3980-050 x_youyj
 */
public class RiyoshaFutangakuGemmenGaitoshaIchiranEditorImpl implements IRiyoshaFutangakuGemmenGaitoshaIchiranEditor {

    private final ChohyoShutsuryokuJohoShutokuResultEntity entity;
    private static final RString スペース = new RString("　");
    private static final RString 作成 = new RString("作成");
    private static final RString ASTERISK = new RString("*");
    private static final RString 課 = new RString("課");
    private static final RString 空白 = new RString("");
    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");
    private static final RString 却下 = new RString("却下");
    private static final RString 承認 = new RString("承認");
    private RString str;

    /**
     * インスタンスを生成します。
     *
     * @param entity entity
     */
    protected RiyoshaFutangakuGemmenGaitoshaIchiranEditorImpl(ChohyoShutsuryokuJohoShutokuResultEntity entity) {
        this.entity = entity;
    }

    /**
     * 利用負担額減額免除認定証項目を編集する
     *
     * @param source source
     * @return RiyoshaFutangakuGemmenGaitoshaIchiranReportSource
     */
    @Override
    public RiyoshaFutangakuGemmenGaitoshaIchiranReportSource edit(RiyoshaFutangakuGemmenGaitoshaIchiranReportSource source) {
        return edit項目(source);
    }

    private RiyoshaFutangakuGemmenGaitoshaIchiranReportSource edit項目(RiyoshaFutangakuGemmenGaitoshaIchiranReportSource source) {
        edit作成日時(source);
        source.title = entity.get帳票タイトル();
        //TODO
        source.hokenshaNo = entity.get導入団体コード();
        source.hokenshaName = entity.get導入団体名称();
//        source.shutsuryokujun1 = entity.get導入団体().getShichosonName_();
        source.listUpper_1 = entity.get被保険者番号();
        if (null != edit宛名()) {
            source.listUpper_2 = edit宛名().get住所().get郵便番号().getColumnValue();
            source.listUpper_3 = edit宛名().get名称().getName().getColumnValue();
            source.listUpper_4 = edit宛名().get年齢算出().get年齢();
        }
        if (entity.get利用者負担額減額Entity() != null && (entity.get利用者負担額減額Entity().getShinseiYMD() != null
                || entity.get利用者負担額減額Entity().getKetteiYMD() != null)) {
            source.listUpper_5 = editFormmatDate(entity.get利用者負担額減額Entity().getShinseiYMD());
            source.listUpper_6 = editFormmatDate(entity.get利用者負担額減額Entity().getKetteiYMD());
        }
        source.listUpper_7 = eidt空白と空白以外(entity.is老齢福祉年金受給者());
        if (ONE.equals(entity.get本人課税区分())) {
            source.listUpper_8 = 課;
        } else {
            source.listUpper_8 = 空白;
        }
        source.listUpper_9 = eidt空白と課(entity.is所得税課税者());
        source.listUpper_10 = eidt空白と空白以外(entity.is生活保護受給者());
        source.listUpper_11 = 空白;
        if (get要介護度(entity.get厚労省IF識別コード(), entity.get認定情報Entity().get要介護状態区分コード()) != null) {
            source.listUpper_12 = get要介護度(entity.get厚労省IF識別コード(), entity.get認定情報Entity().get要介護状態区分コード()).getName();
        }
        source.listUpper_13 = editFormmatDate(entity.get認定情報Entity().get認定年月日());
        if (null != entity.get世帯員Entity().getPsmEntity()) {
            source.listUpper_14 = edit世帯員宛名().get名称().getName().getColumnValue();
            source.listUpper_15 = edit世帯員宛名().get住民状態().住民状態略称();
        }
        if (ONE.equals(entity.get世帯員Entity().get課税区分())) {
            source.listUpper_16 = 課;
        } else {
            source.listUpper_16 = 空白;
        }
        if (entity.get世帯員Entity().get課税所得額().compareTo(ZERO) > 0) {
            source.listUpper_17 = 課;
        } else {
            source.listUpper_17 = 空白;
        }
        source.listUpper_18 = 空白;
        edit項目１(source);
        return source;
    }

    private RiyoshaFutangakuGemmenGaitoshaIchiranReportSource edit項目１(
            RiyoshaFutangakuGemmenGaitoshaIchiranReportSource source) {

        source.listCenter_1 = entity.get利用者負担額減額Entity().getShoKisaiHokenshaNo().getColumnValue();
        if (null != edit宛名()) {
            source.listCenter_2 = edit宛名().get住所().get全国住所コード().getColumnValue();
            source.listCenter_3 = edit宛名().get住所().get住所();
            source.listCenter_4 = edit宛名().get住民状態().住民状態略称();
        }
        if (entity.get利用者負担額減額Entity() != null && (entity.get利用者負担額減額Entity().getTekiyoKaishiYMD() != null
                || entity.get利用者負担額減額Entity().getTekiyoShuryoYMD() != null)) {
            source.listCenter_5 = editFormmatDate(entity.get利用者負担額減額Entity().getTekiyoKaishiYMD());
            source.listCenter_6 = editFormmatDate(entity.get利用者負担額減額Entity().getTekiyoShuryoYMD());
        }
        source.listCenter_7 = entity.get入所施設コード();
        source.listCenter_8 = eidt空白と空白以外(entity.is旧措置者フラグ());
        source.listCenter_9 = editFormmatDate(entity.get認定情報Entity().get認定有効期間開始年月日());

        if (null != entity.get世帯員Entity().getPsmEntity()) {
            source.listCenter_10 = edit世帯員宛名().get名称().getName().getColumnValue();
            source.listCenter_11 = edit世帯員宛名().get住民状態().住民状態略称();
        }
        if (ONE.equals(entity.get世帯員Entity().get課税区分())) {
            source.listCenter_12 = 課;
        } else {
            source.listCenter_12 = 空白;
        }
        if (entity.get世帯員Entity().get課税所得額().compareTo(ZERO) > 0) {
            source.listCenter_13 = 課;
        } else {
            source.listCenter_13 = 空白;
        }
        source.listCenter_14 = 空白;

        if (null != edit宛名()) {
            source.listLower_1 = edit宛名().get行政区画().getGyoseiku().getコード().getColumnValue();
            source.listLower_2 = edit宛名().get行政区画().getGyoseiku().get名称();
        }
        if (ZERO.equals(entity.get利用者負担額減額Entity().getKetteiKubun())) {
            source.listLower_3 = 却下;
        } else if (ONE.equals(entity.get利用者負担額減額Entity().getKetteiKubun())) {
            source.listLower_3 = 承認;
        } else {
            source.listLower_3 = 空白;
        }
        if (entity.get利用者負担額減額Entity() == null || entity.get利用者負担額減額Entity().getKyuhuritsu() == null) {
            source.listLower_4 = 空白;
        } else {
            source.listLower_4 = new RString(entity.get利用者負担額減額Entity().getKyuhuritsu().getColumnValue().toString());
        }
        source.listLower_5 = entity.get入所施設名称();
        source.listLower_6 = editFormmatDate(entity.get認定情報Entity().get認定有効期間終了年月日());
        if (null != entity.get世帯員Entity().getPsmEntity()) {
            source.listLower_7 = edit世帯員宛名().get名称().getName().getColumnValue();
            source.listLower_8 = edit世帯員宛名().get住民状態().住民状態略称();
        }
        if (ONE.equals(entity.get世帯員Entity().get課税区分())) {
            source.listLower_9 = 課;
        } else {
            source.listLower_9 = 空白;
        }
        if (entity.get世帯員Entity().get課税所得額().compareTo(ZERO) > 0) {
            source.listLower_10 = 課;
        } else {
            source.listLower_10 = 空白;
        }
        source.listLower_11 = 空白;
        return source;
    }

    private IKojin edit世帯員宛名() {
        if (null != entity.get世帯員Entity().getPsmEntity()) {
            IKojin kojin = ShikibetsuTaishoFactory.createKojin(entity.get世帯員Entity().getPsmEntity());
            return kojin;
        }
        return null;
    }

    private IYokaigoJotaiKubun get要介護度(KoroshoInterfaceShikibetsuCode 厚労省IF識別コード, RString 要介護状態区分コード) {
        IYokaigoJotaiKubun kubun = YokaigoJotaiKubunSupport.toValue(厚労省IF識別コード, 要介護状態区分コード);
        return kubun;
    }

    private void edit作成日時(RiyoshaFutangakuGemmenGaitoshaIchiranReportSource source) {
        source.printTimeStamp = get帳票作成日時();
    }

    private RString get帳票作成日時() {
        if (entity.get帳票作成日時() == null) {
            return 空白;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("平成yyyy年MM月dd日");
        SimpleDateFormat everyMinute = new SimpleDateFormat("HH時mm分ss秒");
        RString year = new RString(formatter.format(entity.get帳票作成日時()));
        RString minute = new RString(everyMinute.format(new Date()));
        str = year.concat(スペース).concat(minute).concat(スペース).concat(作成);
        return str;
    }

    private IKojin edit宛名() {
        if (null != entity.getPsmEntity()) {
            IKojin kojin = ShikibetsuTaishoFactory.createKojin(entity.getPsmEntity());
            return kojin;
        }
        return null;
    }

    private RString editFormmatDate(FlexibleDate obj) {
        SimpleDateFormat formatter = new SimpleDateFormat("平yyyy年MM月dd日");
        if (obj.isEmpty()) {
            return 空白;
        }
        RString strDate = new RString(formatter.format(obj));
        return strDate;
    }

    private RString eidt空白と空白以外(boolean obj) {
        RString naiYou;
        if (obj) {
            naiYou = ASTERISK;
        } else {
            naiYou = 空白;
        }
        return naiYou;
    }

    private RString eidt空白と課(boolean obj) {
        RString naiYou;
        if (obj) {
            naiYou = 課;
        } else {
            naiYou = 空白;
        }
        return naiYou;
    }
}
