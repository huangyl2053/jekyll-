/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0810023;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiShinryoTokubetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiShinryohi;
import jp.co.ndensan.reams.db.dbc.business.core.basic.TokuteiShinryoServiceCode;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810023.TokuteiShinryouhiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810023.ddgToteishinryoTokubetushinryo_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810023.dgdTokuteiShinryohi_Row;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBCCodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 償還払い状況照会_特定診療費画面のハンドラクラスです。
 *
 * @reamsid_L DBC-1010-150 wangkanglei
 */
public class TokuteiShinryohiHandler {

    private final TokuteiShinryouhiDiv div;
    private static final RString 設定不可 = new RString("0");
    private static final RString 単位 = new RString("単位");
    private static final RString 回まで = new RString("回まで");
    private static final RString 設定可_任意 = new RString("2");
    private static final FlexibleYearMonth 平成２４年４月 = new FlexibleYearMonth("201204");
    private static final RString 改行 = new RString("\n");
    private static final int NUM_0 = 0;

    /**
     * コンストラクタです。
     *
     * @param div TokuteiShinryouhiDiv
     */
    public TokuteiShinryohiHandler(TokuteiShinryouhiDiv div) {
        this.div = div;
    }

    /**
     * ヘッダーエリアの設定のメソッドます。
     *
     * @param サービス年月 サービス年月
     * @param 事業者番号 事業者番号
     * @param 申請日 申請日
     * @param 明細番号 明細番号
     * @param 証明書 証明書
     */
    public void setヘッダーエリア(
            FlexibleYearMonth サービス年月,
            JigyoshaNo 事業者番号,
            RDate 申請日,
            RString 明細番号,
            RString 証明書) {
        div.getPanelTwo().getTxtServiceTeikyoYM().setValue(new RDate(サービス年月.toString()));
        div.getPanelTwo().getTxtShinseiYMD().setValue(申請日);
        div.getPanelTwo().getTxtJigyoshaBango().setValue(事業者番号.getColumnValue());
        div.getPanelTwo().getTxtMeisaibango().setValue(明細番号);
        div.getPanelTwo().getTxtShomeisho().setValue(証明書);
    }

    /**
     * ボタン表示制御処理のメソッドます。
     *
     * @param entity ShikibetsuNoKanri
     * @param サービス年月 サービス年月
     */
    public void setボタン表示制御処理(ShikibetsuNoKanri entity, FlexibleYearMonth サービス年月) {

        if (設定不可.equals(entity.get基本設定区分())) {
            div.getPanelTwo().getBtnKihoninfo().setDisabled(true);
        }
        if (設定不可.equals(entity.get明細設定区分())) {
            div.getPanelTwo().getBtnKyufuMeisai().setDisabled(true);
        }
        if (設定不可.equals(entity.get居宅計画費設定区分())) {
            div.getPanelTwo().getBtnServiceKeikakuhi().setDisabled(true);
        }
        if (設定不可.equals(entity.get特定入所者設定区分())) {
            div.getPanelTwo().getBtnTokuteinyushosha().setDisabled(true);
        }
        if (設定不可.equals(entity.get食事費用設定区分())) {
            div.getPanelTwo().getBtnShokujihiyo().setDisabled(true);
        }
        if (設定不可.equals(entity.get集計設定区分())) {
            div.getPanelTwo().getBtnSeikyugaku().setDisabled(true);
        }
        if (設定不可.equals(entity.get社会福祉法人軽減設定区分())) {
            div.getPanelTwo().getBtnShafuku().setDisabled(true);
        }
        if (設定不可.equals(entity.get明細住所地特例設定区分())) {
            div.getPanelTwo().getBtnKyufuhiMeisaiJyutoku().setDisabled(true);
        }
        if (設定可_任意.equals(entity.get所定疾患施設療養設定区分())
                && 平成２４年４月.isBeforeOrEquals(サービス年月)) {
            div.getPanelTwo().getBtnKinkyujiShoteiShokan().setDisplayNone(false);
            div.getPanelTwo().getBtnKinkyujiShoteiShokan().setVisible(true);
            div.getPanelTwo().getBtnKinkyujiShisetsu().setVisible(false);
            div.getPanelTwo().getBtnKinkyujiShisetsu().setDisplayNone(true);
        } else {
            div.getPanelTwo().getBtnKinkyujiShoteiShokan().setVisible(false);
            if (設定不可.equals(entity.get緊急時施設療養設定区分())) {
                div.getPanelTwo().getBtnKinkyujiShisetsu().setDisabled(true);
            }
        }
    }

    /**
     * 特定診療費_特別診療費一覧グリッドの設定のメソッドます。
     *
     * @param list List<ShokanTokuteiShinryoTokubetsuRyoyo>
     */
    public void set特定診療費_特別診療費一覧グリッド(List<ShokanTokuteiShinryoTokubetsuRyoyo> list) {
        List<dgdTokuteiShinryohi_Row> dataSource = new ArrayList<>();
        for (ShokanTokuteiShinryoTokubetsuRyoyo entity : list) {
            dgdTokuteiShinryohi_Row row = new dgdTokuteiShinryohi_Row();
            row.setShobyoName(entity.get傷病名());
            row.setShikibetsuNo(entity.get識別番号());
            row.setTani(DecimalFormatter.toコンマ区切りRString(new Decimal(entity.get単位数()), NUM_0));
            row.setKaisu(DecimalFormatter.toコンマ区切りRString(new Decimal(entity.get回数()), NUM_0));
            row.setGokeiTani(DecimalFormatter.toコンマ区切りRString(new Decimal(entity.get合計単位数()), NUM_0));
            row.setRemban(entity.get連番());
            dataSource.add(row);
        }
        div.getPanelThree().getDgdTokuteiShinryohi().setDataSource(dataSource);
    }

    /**
     * 特定診療費一覧グリッドの設定のメソッドます。
     *
     * @param shokanTokuteiShinryohiList List<ShokanTokuteiShinryohi>
     */
    public void set特定診療費一覧グリッド(List<ShokanTokuteiShinryohi> shokanTokuteiShinryohiList) {
        List<ddgToteishinryoTokubetushinryo_Row> dataSource = new ArrayList<>();
        for (ShokanTokuteiShinryohi entity : shokanTokuteiShinryohiList) {
            ddgToteishinryoTokubetushinryo_Row row = new ddgToteishinryoTokubetushinryo_Row();
            row.setShobyouName(entity.get傷病名());
            row.setShidouKanri(DecimalFormatter.toコンマ区切りRString(new Decimal(entity.get指導管理料等単位数()), NUM_0));
            row.setRihabiri(DecimalFormatter.toコンマ区切りRString(new Decimal(entity.getリハビリテーション単位数()), NUM_0));
            row.setSeishinka(DecimalFormatter.toコンマ区切りRString(new Decimal(entity.get精神科専門療法単位数()), NUM_0));
            row.setEkusuLine(DecimalFormatter.toコンマ区切りRString(new Decimal(entity.get単純エックス線単位数()), NUM_0));
            row.setSochi(DecimalFormatter.toコンマ区切りRString(new Decimal(entity.get措置単位数()), NUM_0));
            row.setTejyutsu(DecimalFormatter.toコンマ区切りRString(new Decimal(entity.get手術単位数()), NUM_0));
            row.setGoukeyiTanyi(DecimalFormatter.toコンマ区切りRString(new Decimal(entity.get合計単位数()), NUM_0));
            row.setRemban(entity.get連番());
            dataSource.add(row);
        }
        div.getPanelThree().getDdgToteishinryoTokubetushinryo().setDataSource(dataSource);
    }

    /**
     * 特定診療費_特別診療費パネルの設定のメソッドます。
     *
     * @param list List<ShokanTokuteiShinryoTokubetsuRyoyo>
     * @param サービス年月 サービス年月
     * @param 様式番号 RString
     */
    public void set特定診療費_特別診療費パネル(List<ShokanTokuteiShinryoTokubetsuRyoyo> list,
            FlexibleYearMonth サービス年月,
            RString 様式番号) {

        ShokanTokuteiShinryoTokubetsuRyoyo entity = list.get(0);
        TokuteiShinryoServiceCode serviceCode = ShokanbaraiJyokyoShokai.createInstance()
                .getTokuteiShinryoServiceCodeInfo(
                        new ShikibetsuCode(entity.get識別番号()),
                        サービス年月,
                        様式番号);
        div.getPanelThree().getPanelFive().getTxtShobyoMeiDown().setValue(entity.get傷病名());
        div.getPanelThree().getPanelFive().getTxtShikibetsuNo().setValue(entity.get識別番号());
        if (serviceCode != null && serviceCode.toEntity().getServiceMeisho() != null) {
            FlexibleDate date = new FlexibleDate(RDate.getNowDate().toDateString());
            div.getPanelThree().getPanelFive().getTxtName().setValue(serviceCode.toEntity().getServiceMeisho());
            if (serviceCode.toEntity().getSanteiTani() != null) {
                UzT0007CodeEntity code1 = CodeMaster.getCode(SubGyomuCode.DBC介護給付, DBCCodeShubetsu.算定単位.getコード(),
                        new Code(serviceCode.toEntity().getSanteiTani()), date);
                RStringBuilder builder1 = new RStringBuilder();
                builder1.append(code1.getコード名称());
                builder1.append(serviceCode.toEntity().getTaniSu());
                builder1.append(単位);
                div.getPanelThree().getPanelFive().getLblComment1().setText(builder1.toRString());
            } else {
                div.getPanelThree().getPanelFive().getLblComment1().setText(RString.EMPTY);
            }
            if (serviceCode.toEntity().getSanteiSeiyakuKikan() != null) {
                UzT0007CodeEntity code2 = CodeMaster.getCode(SubGyomuCode.DBC介護給付,
                        DBCCodeShubetsu.算定期間回数制限_期間_時期.getコード(),
                        new Code(serviceCode.toEntity().getSanteiSeiyakuKikan()), date);
                RStringBuilder builder2 = new RStringBuilder();
                builder2.append(code2.getコード名称());
                builder2.append(serviceCode.toEntity().getSanteiSeiyakuKaisu());
                builder2.append(回まで);
                div.getPanelThree().getPanelFive().getLblComment2().setText(builder2.toRString());
            } else {
                div.getPanelThree().getPanelFive().getLblComment2().setText(RString.EMPTY);
            }
        } else {
            div.getPanelThree().getPanelFive().getLblComment1().setText(RString.EMPTY);
            div.getPanelThree().getPanelFive().getLblComment2().setText(RString.EMPTY);
        }
        div.getPanelThree().getPanelFive().getTxtTanyi().setValue(
                DecimalFormatter.toコンマ区切りRString(new Decimal(entity.get単位数()), NUM_0));
        div.getPanelThree().getPanelFive().getTxtKaiyisuNisu().setValue(new Decimal(entity.get回数()));
        div.getPanelThree().getPanelFive().getTxtGoukeiTanyi().setValue(new Decimal(entity.get合計単位数()));
        div.getPanelThree().getPanelFive().getTxtTekiyoDown().setValue(entity.get摘要());
    }

    /**
     * 特定診療費パネルの設定のメソッドます。
     *
     * @param list List<ShokanTokuteiShinryohi>
     */
    public void set特定診療費パネル(List<ShokanTokuteiShinryohi> list) {
        ShokanTokuteiShinryohi entity = list.get(0);
        div.getPanelThree().getPanelFour().getTxtShobyoMei().setValue(entity.get傷病名());
        div.getPanelThree().getPanelFour().getTxtShidouKanri().setValue(new Decimal(entity.get指導管理料等単位数()));
        div.getPanelThree().getPanelFour().getTxtRibabiriteishon().setValue(new Decimal(entity.getリハビリテーション単位数()));
        div.getPanelThree().getPanelFour().getTxtSeishinkaSenmon().setValue(new Decimal(entity.get精神科専門療法単位数()));
        div.getPanelThree().getPanelFour().getTxtTanjyunXline().setValue(new Decimal(entity.get単純エックス線単位数()));
        div.getPanelThree().getPanelFour().getTxtSochi().setValue(new Decimal(entity.get措置単位数()));
        div.getPanelThree().getPanelFour().getTxtTejyutsu().setValue(new Decimal(entity.get手術単位数()));
        div.getPanelThree().getPanelFour().getTxtGoukei().setValue(new Decimal(entity.get合計単位数()));
        RStringBuilder builder = new RStringBuilder();
        builder.append(entity.get摘要１()).append(改行);
        builder.append(entity.get摘要２()).append(改行);
        builder.append(entity.get摘要３()).append(改行);
        builder.append(entity.get摘要４()).append(改行);
        builder.append(entity.get摘要５()).append(改行);
        builder.append(entity.get摘要６()).append(改行);
        builder.append(entity.get摘要７()).append(改行);
        builder.append(entity.get摘要８()).append(改行);
        builder.append(entity.get摘要９()).append(改行);
        builder.append(entity.get摘要１０()).append(改行);
        builder.append(entity.get摘要１１()).append(改行);
        builder.append(entity.get摘要１２()).append(改行);
        builder.append(entity.get摘要１３()).append(改行);
        builder.append(entity.get摘要１４()).append(改行);
        builder.append(entity.get摘要１５()).append(改行);
        builder.append(entity.get摘要１６()).append(改行);
        builder.append(entity.get摘要１７()).append(改行);
        builder.append(entity.get摘要１８()).append(改行);
        builder.append(entity.get摘要１９()).append(改行);
        builder.append(entity.get摘要２０());
        div.getPanelThree().getPanelFour().getTxtMutiTekiyo().setValue(builder.toRString());
    }
}
