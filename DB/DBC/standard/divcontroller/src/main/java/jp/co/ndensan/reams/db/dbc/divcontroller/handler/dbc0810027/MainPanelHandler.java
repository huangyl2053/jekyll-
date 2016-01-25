/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810027;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKinkyuShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810027.MainPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810027.dgdKinkyujiShiseturyoyo_Row;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * @author XuPeng
 */
public class MainPanelHandler {

    private final MainPanelDiv div;
    private static final RString 設定不可 = new RString("0");

    private MainPanelHandler(MainPanelDiv div) {
        this.div = div;
    }

    public static MainPanelHandler of(MainPanelDiv div) {
        return new MainPanelHandler(div);
    }

    public void initPanelHead(FlexibleYearMonth サービス年月,
            RDate 申請日,
            JigyoshaNo 事業者番号,
            RString 明細番号,
            RString 証明書,
            RString 様式番号) {
        div.getPanelHead().getTxtServiceTeikyoYM().setDomain(new RYearMonth(
                サービス年月.wareki().toDateString()));
        div.getPanelHead().getTxtShinseiYMD().setValue(new RDate(申請日.wareki().toDateString().toString()));
        div.getPanelHead().getTxtJigyoshaBango().setValue(事業者番号.getColumnValue());
        div.getPanelHead().getTxtMeisaiBango().setValue(明細番号);
        div.getPanelHead().getTxtShomeisho().setValue(証明書);
    }

    public void initDgdKinkyujiShiseturyoyo(List<ShokanKinkyuShisetsuRyoyo> list) {
        List<dgdKinkyujiShiseturyoyo_Row> lists = new ArrayList<>();
        for (ShokanKinkyuShisetsuRyoyo result : list) {
            dgdKinkyujiShiseturyoyo_Row row = new dgdKinkyujiShiseturyoyo_Row();
            row.setDefaultDataName1(result.get緊急時傷病名１());
            row.setDefaultDataName2(result.get緊急時治療開始年月日１().wareki().toDateString());
            row.setDefaultDataName3(new RString(Integer.valueOf(result.get緊急時治療管理単位数()).toString()));
            row.setDefaultDataName4(new RString(Integer.valueOf(result.get緊急時施設療養費合計単位数()).toString()));
            row.setDefaultDataName5(result.get連番());
            lists.add(row);
        }
        div.getDgdKinkyujiShiseturyoyo().setDataSource(lists);
    }

    //test
    public void initList() {
        List<dgdKinkyujiShiseturyoyo_Row> lists = new ArrayList<>();
        dgdKinkyujiShiseturyoyo_Row row = new dgdKinkyujiShiseturyoyo_Row();
        row.setDefaultDataName1(new RString("cold"));
        row.setDefaultDataName2(new RDate(2016, 01, 20).wareki().toDateString());
        row.setDefaultDataName3(new RString(Integer.valueOf(123).toString()));
        row.setDefaultDataName4(new RString(Integer.valueOf(123).toString()));
        row.setDefaultDataName5(new RString("1"));
        lists.add(row);
        div.getDgdKinkyujiShiseturyoyo().setDataSource(lists);
    }

    //test
    public void set() {
        div.getTxtKinkyuShobyoName1().setValue(new RString("cold"));
        div.getTxtKinkyuJiryoStartYMD1().setValue(new RDate(
                new RDate(2016, 01, 20).wareki().toDateString().toString()));

        div.getTxtOshinNissu().setValue(new Decimal(123));
        div.getTxtOshinYiryokikanName().setValue(new RString("asdf"));
        div.getTxtTuyinNissu().setValue(new Decimal(12));
        div.getTxtTuyinYiryokikanName().setValue(new RString("asdf"));
        div.getTxtTikiyo().setValue(new RString("very hot"));

        div.getTxtkinkyuChiryoKanriTanisu().setValue(new Decimal(12));
        div.getTxtkinkyuChiryoKanriNissu().setValue(new Decimal(1));
        div.getTxtkinkyuChiryoKanriSubTotal().setValue(new Decimal(12));
        div.getTxtrehabilitationTanisu().setValue(new Decimal(12));
        div.getTxtshujutsuTanisu().setValue(new Decimal(2));
        div.getTxtHoshasenChiryoTanisu().setValue(new Decimal(1));
        div.getTxtShochiTanisu().setValue(new Decimal(1));
        div.getTxtMasuiTanisu().setValue(new Decimal(2));
        div.getTxtKinkyuShisetsuRyoyohiTotalTanisu().setValue(new Decimal(13));
    }

    public void set傷病名(ShokanKinkyuShisetsuRyoyo result) {
        div.getTxtKinkyuShobyoName1().setValue(result.get緊急時傷病名１());
        div.getTxtKinkyuShobyoName2().setValue(result.get緊急時傷病名２());
        div.getTxtKinkyuShobyoName3().setValue(result.get緊急時傷病名３());
        div.getTxtKinkyuJiryoStartYMD1().setValue(new RDate(
                result.get緊急時治療開始年月日１().wareki().toDateString().toString()));
        div.getTxtKinkyuJiryoStartYMD2().setValue(new RDate(
                result.get緊急時治療開始年月日２().wareki().toDateString().toString()));
        div.getTxtKinkyuJiryoStartYMD3().setValue(new RDate(
                result.get緊急時治療開始年月日３().wareki().toDateString().toString()));
    }

    public void set往診通院(ShokanKinkyuShisetsuRyoyo result) {
        div.getTxtOshinNissu().setValue(result.get往診日数());
        div.getTxtOshinYiryokikanName().setValue(result.get往診医療機関名());
        div.getTxtTuyinNissu().setValue(result.get通院日数());
        div.getTxtTuyinYiryokikanName().setValue(result.get通院医療機関名());
        div.getTxtTikiyo().setValue(get摘要(result));
    }

    private RString get摘要(ShokanKinkyuShisetsuRyoyo result) {
        RStringBuilder tekiyou = new RStringBuilder(result.get摘要１());
        tekiyou.append(result.get摘要２());
        tekiyou.append(result.get摘要３());
        tekiyou.append(result.get摘要４());
        tekiyou.append(result.get摘要５());
        tekiyou.append(result.get摘要６());
        tekiyou.append(result.get摘要７());
        tekiyou.append(result.get摘要８());
        tekiyou.append(result.get摘要９());
        tekiyou.append(result.get摘要１０());
        tekiyou.append(result.get摘要１１());
        tekiyou.append(result.get摘要１２());
        tekiyou.append(result.get摘要１３());
        tekiyou.append(result.get摘要１４());
        tekiyou.append(result.get摘要１５());
        tekiyou.append(result.get摘要１６());
        tekiyou.append(result.get摘要１７());
        tekiyou.append(result.get摘要１８());
        tekiyou.append(result.get摘要１９());
        tekiyou.append(result.get摘要２０());
        return tekiyou.toRString();
    }

    public void set治療点数(ShokanKinkyuShisetsuRyoyo result) {
        div.getTxtkinkyuChiryoKanriTanisu().setValue(new Decimal(result.get緊急時治療管理単位数()));
        div.getTxtkinkyuChiryoKanriNissu().setValue(result.get緊急時治療管理日数());
        div.getTxtkinkyuChiryoKanriSubTotal().setValue(new Decimal(result.get緊急時治療管理小計()));
        div.getTxtrehabilitationTanisu().setValue(new Decimal(result.getリハビリテーション単位数()));
        div.getTxtshujutsuTanisu().setValue(new Decimal(result.get手術単位数()));
        div.getTxtHoshasenChiryoTanisu().setValue(new Decimal(result.get放射線治療単位数()));
        div.getTxtShochiTanisu().setValue(new Decimal(result.get処置単位数()));
        div.getTxtMasuiTanisu().setValue(new Decimal(result.get麻酔単位数()));
        div.getTxtKinkyuShisetsuRyoyohiTotalTanisu().setValue(new Decimal(result.get緊急時施設療養費合計単位数()));
    }

    public void setボタン表示制御処理(ShikibetsuNoKanriEntity 識別番号, FlexibleYearMonth サービス年月) {

        //基本情報
        if (設定不可.equals(識別番号.getEntity().getKihonSetteiKubun())) {
            div.getPanelHead().getBtnKihonInfo().setDisabled(true);
        }
        //給付費明細
        if (設定不可.equals(識別番号.getEntity().getMeisaiSetteiKubun())) {
            div.getPanelHead().getBtnKyufuhiMeisai().setDisabled(true);
        }
        //特定診療費
        if (設定不可.equals(識別番号.getEntity().getTokuteiShinryoSetteiKubun())) {
            div.getPanelHead().getBtnTokuteiShinryohi().setDisabled(true);
        }
        //サービス計画費
        if (設定不可.equals(識別番号.getEntity().getKyotakuKeikakuSetteiKubun())) {
            div.getPanelHead().getBtnServiceKeikakuhi().setDisabled(true);
        }
        // 特定入所者費用ボタン
        if (設定不可.equals(識別番号.getEntity().getTokuteinyushoshaSetteiKubun())) {
            div.getPanelHead().getBtnTokuteiNyushosya().setDisabled(true);
        }
        // 「食事費用」ボタン
        if (設定不可.equals(識別番号.getEntity().getShokujiHiyosetteiKubun())) {
            div.getPanelHead().getBtnShokujiHiyo().setDisabled(true);
        }
        // 「請求額集計」ボタン
        if (設定不可.equals(識別番号.getEntity().getShukeiSetteiKubun())) {
            div.getPanelHead().getBtnSeikyugakuShukei().setDisabled(true);
        }
        // 「社福軽減額」ボタン
        if (設定不可.equals(識別番号.getEntity().getShakaifukushiKeigenSetteiKubun())) {
            div.getPanelHead().getBtnShafukukeigengaku().setDisabled(true);
        }
        //給付費明細（住特）
        if (設定不可.equals(識別番号.getEntity().getMeisaiJushochitokureiSetteiKubun())) {
            div.getPanelHead().getBtnKyufuhiMeisaiJyutoku().setDisabled(true);
        }

    }
}
