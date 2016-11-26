/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200061;

import jp.co.ndensan.reams.db.dbc.entity.report.dbc200061.ServiceCodeIchiranSource;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7131KaigoServiceNaiyouEntity;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票設計_DBCMNJ2006_サービスコード一覧表BodyEditor
 *
 * @reamsid_L DBC-3310-040 jiangxiaolong
 */
public class ServiceCodeIchiranBodyEditor
        implements IServiceCodeIchiranEditor {

    private DbT7131KaigoServiceNaiyouEntity entity;
    private static final RString MAX_YM = new RString("999999");
    private static final RString INT_05 = new RString("05");
    private static final RString 定率 = new RString("定率");
    private static final RString 定額 = new RString("定額");
    private static final RString 区分_1 = new RString("1");
    private static final RString 区分_2 = new RString("2");
    private static final RString HOSHI = new RString("※");

    /**
     * コンストラクタです
     *
     * @param parameter ServiceCodeIchiranParameter
     */
    public ServiceCodeIchiranBodyEditor(
            ServiceCodeIchiranParameter parameter) {
        if (null != parameter && null != parameter.getサービスコード一覧表()) {
            this.entity = parameter.getサービスコード一覧表().get介護サービス内容();
        }

    }

    @Override
    public ServiceCodeIchiranSource edit(
            ServiceCodeIchiranSource source) {
        if (null == entity) {
            return source;
        }
        edit明細(source);
        setPageBreakEmpty(source);
        return source;
    }

    private void setPageBreakEmpty(ServiceCodeIchiranSource source) {
        if (source.List1_1 == null) {
            source.List1_1 = RString.EMPTY;
        }
    }

    private void edit明細(ServiceCodeIchiranSource source) {
        source.List1_1 = getColumnValue(entity.getServiceShuruiCd());
        source.List1_2 = entity.getServiceKoumokuCd();
        source.List1_3 = entity.getServiceName();
        source.List1_4 = doパターン62(entity.getTeikyoKaishiYM());
        if (!MAX_YM.equals(doパターン62(entity.getTeikyoShuryoYM()))) {
            source.List1_5 = doパターン62(entity.getTeikyoShuryoYM());
        }
        if (!INT_05.equals(getColumnValue(entity.getTanisuShikibetsuCode()))) {
            source.List1_6 = doカンマ編集(new Decimal(entity.getTaniSu()));
        }
        source.List1_7 = getColumnValue(entity.getTanisuShikibetsuCode());
        if (区分_1.equals(entity.getRiyosyaFutanTeiritsuTeigakuKubun())) {
            source.List1_8 = 定率;
        } else if (区分_2.equals(entity.getRiyosyaFutanTeiritsuTeigakuKubun())) {
            source.List1_8 = 定額;
        }
        if (null != entity.getKyufuRitsu()) {
            source.List1_9 = doカンマ編集(new Decimal(String.valueOf(entity.getKyufuRitsu())));
        }
        source.List1_10 = entity.getRiyoshaFutanGaku();
        if (区分_2.equals(entity.getTaishoJigyoJishiKubun())) {
            source.List1_11 = HOSHI;
        }
        if (区分_2.equals(entity.getYoshien1JukyushaJishiKubun())) {
            source.List1_12 = HOSHI;
        }
        if (区分_2.equals(entity.getYoshien2JukyushaJishiKubun())) {
            source.List1_13 = HOSHI;
        }
        if (区分_2.equals(entity.getNijiyoboJigyoTaishaJishiKubunHigaito())) {
            source.List1_14 = HOSHI;
        }
        if (区分_1.equals(entity.getGendogakuTaishogaiFlag())) {
            source.List1_15 = HOSHI;
        }
        if (区分_1.equals(entity.getTokubetsuChiikiKasanFlag())) {
            source.List1_16 = HOSHI;
        }
        if (区分_1.equals(entity.getKoshinUmuFoag())) {
            source.List1_17 = HOSHI;
        }
        source.List2_2 = entity.getMotoTaniShikibetsuCd();
        if (!INT_05.equals(source.List2_2) && null != entity.getMotoTensu()) {
            source.List2_1 = doカンマ編集(new Decimal(String.valueOf(entity.getMotoTensu())));
        }
        if (区分_1.equals(entity.getMotoGendogakuTaishogaiFlag())) {
            source.List2_3 = HOSHI;
        }
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

    private RString doパターン62(FlexibleYearMonth ym) {
        if (ym == null) {
            return RString.EMPTY;
        }
        return ym.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private RString doカンマ編集(Decimal number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, 0);
    }

}
