                                                                                                            /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010018;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiFukushiYoguHanbaihiBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010018.FukushiYoguKonyuhiShokaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010018.dgFukushiYoguKonyuhi_Row;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 給付実績の福祉用具購入費を照会の画面処理Handlerクラスです。
 *
 * @reamsid_L DBC-2970-100 zhaoyao
 */
public class FukushiYoguKonyuhiShokaiHandler {

    private final FukushiYoguKonyuhiShokaiDiv div;
    private static final int INT_ZERO = 0;
    private static final RString ZERO = new RString("0");

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public FukushiYoguKonyuhiShokaiHandler(FukushiYoguKonyuhiShokaiDiv div) {
        this.div = div;
    }

    /**
     * 画面の初期化です。
     *
     * @param 給付実績福祉用具販売費リスト List<KyufujissekiFukushiYoguHanbaihiBusiness>
     */
    public void onLoad(List<KyufujissekiFukushiYoguHanbaihiBusiness> 給付実績福祉用具販売費リスト) {
        List<dgFukushiYoguKonyuhi_Row> rowList = new ArrayList<>();
        for (KyufujissekiFukushiYoguHanbaihiBusiness 給付実績福祉用具販売費 : 給付実績福祉用具販売費リスト) {
            rowList.add(setRowData(給付実績福祉用具販売費));
        }
        div.getDgFukushiYoguKonyuhi().setDataSource(rowList);
    }

    private dgFukushiYoguKonyuhi_Row setRowData(KyufujissekiFukushiYoguHanbaihiBusiness 給付実績福祉用具販売費) {
        RString 福祉用具販売年月日 = RString.EMPTY;
        RString 審査年月 = RString.EMPTY;
        if (給付実績福祉用具販売費.get給付実績福祉用具販売費基本情報().get福祉用具販売年月日() != null) {
            福祉用具販売年月日 = 給付実績福祉用具販売費.get給付実績福祉用具販売費基本情報().get福祉用具販売年月日().wareki().toDateString();
        }
        if (給付実績福祉用具販売費.get給付実績福祉用具販売費基本情報().get審査年月() != null) {
            審査年月 = 給付実績福祉用具販売費.get給付実績福祉用具販売費基本情報().get審査年月().toDateString();
        }
        dgFukushiYoguKonyuhi_Row row = new dgFukushiYoguKonyuhi_Row();
        row.setTxtService(給付実績福祉用具販売費.getサービス種類略称());
        row.setTxtKonyuYMD(福祉用具販売年月日);
        row.setTxtShohinName(給付実績福祉用具販売費.get給付実績福祉用具販売費基本情報().get福祉用具商品名());
        row.setTxtShumoku(給付実績福祉用具販売費.get給付実績福祉用具販売費基本情報().get福祉用具種目コード());
        row.setTxtSeizoJigyoshaName(給付実績福祉用具販売費.get給付実績福祉用具販売費基本情報().get福祉用具製造事業者名());
        row.setTxtHanbaiJigyoshaName(給付実績福祉用具販売費.get給付実績福祉用具販売費基本情報().get福祉用具販売事業者名());
        row.setTxtKonyuKingaku(kinngakuFormat(給付実績福祉用具販売費.get給付実績福祉用具販売費基本情報().get販売金額()));
        row.setTxtShinsaYM(審査年月);
        row.setBtnTekiyo(給付実績福祉用具販売費.get給付実績福祉用具販売費基本情報().get摘要_品目コード());
        return row;
    }

    /**
     * ボタン状態の設定です。
     *
     * @param 識別番号管理 識別番号管理
     */
    public void setButton(ShikibetsuNoKanri 識別番号管理) {
        div.getBtnKihon().setDisabled(ZERO.equals(識別番号管理.get基本設定区分()));
        div.getBtnMeisaiShukei().setDisabled(
                ZERO.equals(識別番号管理.get明細設定区分()) && ZERO.equals(識別番号管理.get集計設定区分()));
        div.getBtnShoteiShikkanShisetsuRyoyo().setDisabled(ZERO.equals(識別番号管理.get所定疾患施設療養設定区分()));
        div.getBtnKinkyujiShisetsuRyoyo().setDisabled(ZERO.equals(識別番号管理.get緊急時施設療養設定区分()));
        div.getBtnShokuji().setDisabled(ZERO.equals(識別番号管理.get食事費用設定区分()));
        div.getBtnFukushiYoguKonyu().setDisabled(true);
        div.getBtnTokuteiNyushosha().setDisabled(ZERO.equals(識別番号管理.get特定入所者設定区分()));
        div.getBtnKogakuKaigoService().setDisabled(true);
        div.getBtnTokuteiShinryo().setDisabled(
                ZERO.equals(識別番号管理.get特定診療費設定区分()) && ZERO.equals(識別番号管理.get特定診療特別療養設定区分()));
        div.getBtnKyotakuServiceKeikaku().setDisabled(ZERO.equals(識別番号管理.get居宅計画費設定区分()));
        div.getBtnJutakuKaishu().setDisabled(ZERO.equals(識別番号管理.get住宅改修費設定区分()));
        div.getBtnCareManagement().setDisabled(ZERO.equals(識別番号管理.getケアマネジメント設定区分()));
        div.getBtnShafukuKeigen().setDisabled(ZERO.equals(識別番号管理.get社会福祉法人軽減設定区分()));
    }

    private RString kinngakuFormat(Decimal date) {
        if (date == null || date == Decimal.ZERO) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(date, INT_ZERO);
    }
}
