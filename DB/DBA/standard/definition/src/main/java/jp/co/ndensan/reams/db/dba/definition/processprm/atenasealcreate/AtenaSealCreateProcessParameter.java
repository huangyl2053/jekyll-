/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.processprm.atenasealcreate;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.atenasealcreate.AtenaSealCreateMybatisParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 宛名シール作成のProcessクラスのパラメータ。
 *
 * @reamsid_L DBA-1210-030 zhengsongling
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class AtenaSealCreateProcessParameter implements IBatchProcessParameter {

    private static final RString 全市町村 = new RString("000000");
    private static final RString 抽出対象者_住所地特例者のみ = new RString("4");
    private static final RString 抽出対象者_受給認定申請中を除く = new RString("5");
    private static final RString 業務コード = new RString("DBA");
    private static final RString 資格区分_ICHI = new RString("1");
    private static final RString 資格区分_NI = new RString("2");
    private static final RString 市町村指定_ICHI = new RString("1");
    private static final RString 市町村指定_ZERO = new RString("0");
    private static final RString 市町村指定_NI = new RString("2");
    private static final RString 市町村指定_SAN = new RString("3");
    private static final RString 市町村指定_YOU = new RString("4");
    private static final RString 資格区分_1号日本人 = new RString("1");
    private static final RString 資格区分_2号日本人 = new RString("2");
    private static final RString 資格区分_1号外国人 = new RString("3");
    private static final RString 資格区分_2号外国人 = new RString("4");
    private static final RString 資格区分_1号全て = new RString("5");
    private static final RString 資格区分_2号全て = new RString("6");
    private static final RString 資格区分_全て = new RString("7");
    private static final RString 年齢到達日 = new RString("lblToutatubi");
    private static final RString 送付先又は代納人 = new RString("sofusakiOrDainonin");

    private RString chuushutsutaishousha;
    private RString chuyshutsukukantxt;
    private RString chuushutsukikankaishibi;
    private RString chuushutsukikanshuuryoubi;
    private RString shikakukubun;
    private RString shichousonshitei;
    private RString saiyuusenjyusho;
    private RString keishou;
    private RString hitemotsubangouhyouji;
    private boolean iskatagaki;
    private boolean isshichosonmeisho;
    private boolean istodofukenmeisho;
    private boolean isgunmeisho;
    private Long shutsutuokujyunid;
    private RString gyoumucode;

    /**
     *
     * @param chuushutsutaishousha 抽出対象者
     * @param chuyshutsukukantxt 抽出期間TXT
     * @param chuushutsukikankaishibi 抽出期間開始日
     * @param chuushutsukikanshuuryoubi 抽出期間終了日
     * @param shikakukubun 資格区分
     * @param shichousonshitei 市町村指定
     * @param saiyuusenjyusho 最優先住所
     * @param keishou 敬称
     * @param hitemotsubangouhyouji 被保番号表示
     * @param iskatagaki 方書
     * @param isshichosonmeisho 市町村名称
     * @param istodofukenmeisho 都道府県名称
     * @param isgunmeisho 郡名称
     * @param shutsutuokujyunid 出力順ID
     * @param gyoumucode 業務コード
     */
    public AtenaSealCreateProcessParameter(
            RString chuushutsutaishousha,
            RString chuyshutsukukantxt,
            RString chuushutsukikankaishibi,
            RString chuushutsukikanshuuryoubi,
            RString shikakukubun,
            RString shichousonshitei,
            RString saiyuusenjyusho,
            RString keishou,
            RString hitemotsubangouhyouji,
            boolean iskatagaki,
            boolean isshichosonmeisho,
            boolean istodofukenmeisho,
            boolean isgunmeisho,
            Long shutsutuokujyunid,
            RString gyoumucode) {
        this.chuushutsutaishousha = chuushutsutaishousha;
        this.chuyshutsukukantxt = chuyshutsukukantxt;
        this.chuushutsukikankaishibi = chuushutsukikankaishibi;
        this.chuushutsukikanshuuryoubi = chuushutsukikanshuuryoubi;
        this.shikakukubun = shikakukubun;
        this.shichousonshitei = shichousonshitei;
        this.saiyuusenjyusho = saiyuusenjyusho;
        this.keishou = keishou;
        this.hitemotsubangouhyouji = hitemotsubangouhyouji;
        this.iskatagaki = iskatagaki;
        this.isshichosonmeisho = isshichosonmeisho;
        this.istodofukenmeisho = istodofukenmeisho;
        this.isgunmeisho = isgunmeisho;
        this.shutsutuokujyunid = shutsutuokujyunid;
        this.gyoumucode = gyoumucode;
    }

    /**
     * Mybatisのパラメータを作成します。
     *
     * @param psmShikibetsuTaisho 宛名識別対象抽出PSM
     * @param psmAtesaki 宛先抽出PSM
     * @return AtenaSealCreateMybatisParameter
     */
    public AtenaSealCreateMybatisParameter toAtenaSealCreateMybatisParameter(RString psmShikibetsuTaisho, RString psmAtesaki) {
        boolean is資格区分_全て = false;
        boolean is年齢到達日 = false;
        boolean has市町村指定 = false;
        boolean is第１号開始年月日 = false;
        boolean is第２号開始年月日 = false;
        boolean is送付先または代納人 = false;
        boolean is市町村指定 = false;
        boolean is抽出対象者1 = false;
        boolean isDBA業務コード = false;
        boolean is受給認定申請中を除く = false;
        FlexibleDate kankaishibi_第１号;
        FlexibleDate shuuryoubi_第１号;
        FlexibleDate kankaishibi_第２号;
        FlexibleDate shuuryoubi_第２号;
        List<RString> kubun_1 = new ArrayList<>();
        List<RString> kubun_2 = new ArrayList<>();
        List<RString> shubetsu_1 = new ArrayList<>();
        List<RString> shubetsu_2 = new ArrayList<>();
        if (送付先又は代納人.equals(saiyuusenjyusho)) {
            is送付先または代納人 = true;
        }
        if (年齢到達日.equals(chuyshutsukukantxt)) {
            is年齢到達日 = true;
        }
        if (!全市町村.equals(shichousonshitei)) {
            is市町村指定 = true;
        }
        if (抽出対象者_住所地特例者のみ.equals(chuushutsutaishousha)) {
            is抽出対象者1 = true;
        }
        if (抽出対象者_受給認定申請中を除く.equals(chuushutsutaishousha)) {
            is受給認定申請中を除く = true;
        }
        if (業務コード.equals(gyoumucode)) {
            isDBA業務コード = true;
        }
        RString 第１号被保険者到達基準年齢 = DbBusinessConfig.get(
                ConfigNameDBU.年齢到達基準_第１号被保険者到達基準年齢, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        RString 第２号被保険者到達基準年齢 = DbBusinessConfig.get(
                ConfigNameDBU.年齢到達基準_第２号被保険者到達基準年齢, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        kankaishibi_第１号 = get開始年月日(toFlexibleDate(chuushutsukikankaishibi), 第１号被保険者到達基準年齢);
        shuuryoubi_第１号 = get終了年月日(toFlexibleDate(chuushutsukikanshuuryoubi), 第１号被保険者到達基準年齢);
        kankaishibi_第２号 = get開始年月日(toFlexibleDate(chuushutsukikankaishibi), 第２号被保険者到達基準年齢);
        shuuryoubi_第２号 = get開始年月日(toFlexibleDate(chuushutsukikankaishibi), 第２号被保険者到達基準年齢);
        if (資格区分_1号日本人.equals(shikakukubun)) {
            is第１号開始年月日 = true;
            kubun_1.add(資格区分_ICHI);
            kubun_2.add(資格区分_ICHI);
            shubetsu_1.add(市町村指定_ICHI);
            shubetsu_2.add(市町村指定_ZERO);
        } else if (資格区分_2号日本人.equals(shikakukubun)) {
            is第２号開始年月日 = true;
            kubun_1.add(資格区分_NI);
            kubun_2.add(資格区分_ICHI);
            shubetsu_1.add(市町村指定_ICHI);
            shubetsu_2.add(市町村指定_ZERO);
        } else if (資格区分_1号外国人.equals(shikakukubun)) {
            is第１号開始年月日 = true;
            kubun_1.add(資格区分_ICHI);
            kubun_2.add(資格区分_NI);
            shubetsu_1.add(市町村指定_NI);
            shubetsu_2.add(市町村指定_ZERO);
        } else if (資格区分_2号外国人.equals(shikakukubun)) {
            is第２号開始年月日 = true;
            kubun_1.add(資格区分_NI);
            kubun_2.add(資格区分_NI);
            shubetsu_1.add(市町村指定_NI);
            shubetsu_2.add(市町村指定_ZERO);
        } else if (資格区分_1号全て.equals(shikakukubun)) {
            is第１号開始年月日 = true;
            kubun_1.add(資格区分_ICHI);
            kubun_1.add(資格区分_NI);
            kubun_2.add(資格区分_NI);
            shubetsu_1.add(市町村指定_ICHI);
            shubetsu_1.add(市町村指定_NI);
            shubetsu_2.add(市町村指定_ZERO);
        } else if (資格区分_2号全て.equals(shikakukubun)) {
            is第２号開始年月日 = true;
            kubun_1.add(資格区分_NI);
            kubun_2.add(資格区分_ICHI);
            kubun_2.add(資格区分_NI);
            shubetsu_1.add(市町村指定_SAN);
            shubetsu_1.add(市町村指定_YOU);
            shubetsu_2.add(市町村指定_NI);
        } else if (資格区分_全て.equals(shikakukubun)) {
            is資格区分_全て = true;
            kubun_1.add(資格区分_NI);
            kubun_2.add(資格区分_ICHI);
            kubun_2.add(資格区分_ICHI);
            kubun_2.add(資格区分_NI);
            shubetsu_1.add(市町村指定_ICHI);
            shubetsu_1.add(市町村指定_NI);
            shubetsu_1.add(市町村指定_SAN);
            shubetsu_1.add(市町村指定_YOU);
            shubetsu_2.add(市町村指定_ICHI);
            shubetsu_2.add(市町村指定_NI);
        }
        return AtenaSealCreateMybatisParameter.creatParameter(
                chuushutsutaishousha,
                chuyshutsukukantxt,
                toFlexibleDate(chuushutsukikankaishibi),
                toFlexibleDate(chuushutsukikanshuuryoubi),
                shikakukubun,
                shichousonshitei,
                saiyuusenjyusho,
                keishou,
                hitemotsubangouhyouji,
                iskatagaki,
                isshichosonmeisho,
                istodofukenmeisho,
                isgunmeisho,
                shutsutuokujyunid,
                gyoumucode,
                is資格区分_全て,
                is年齢到達日,
                has市町村指定,
                kankaishibi_第１号,
                shuuryoubi_第１号,
                kankaishibi_第２号,
                shuuryoubi_第２号,
                kubun_1,
                kubun_2,
                shubetsu_1,
                shubetsu_2,
                is第１号開始年月日,
                is第２号開始年月日,
                is送付先または代納人,
                is市町村指定,
                is抽出対象者1,
                isDBA業務コード,
                is受給認定申請中を除く,
                psmShikibetsuTaisho,
                psmAtesaki
        );
    }

    private FlexibleDate get開始年月日(FlexibleDate 抽出期間開始日, RString 第１号被保険者到達基準年齢) {
        return 抽出期間開始日.minusYear(Integer.valueOf(第１号被保険者到達基準年齢.toString())).plusDay(1);
    }

    private FlexibleDate get終了年月日(FlexibleDate 抽出期間終了日, RString 第１号被保険者到達基準年齢) {
        return 抽出期間終了日.minusYear(Integer.valueOf(第１号被保険者到達基準年齢.toString())).plusDay(1);
    }

    private FlexibleDate toFlexibleDate(RString obj) {
        if (obj == null) {
            return FlexibleDate.EMPTY;
        }
        return new FlexibleDate(new RDate(obj.toString()).toDateString());
    }

}
