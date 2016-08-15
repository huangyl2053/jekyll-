/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.HikazeiNenkinKensaku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.houshold.HousholdBusiness;
import jp.co.ndensan.reams.db.dbd.service.core.houshold.HousholdFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 【共有子Div】非課税年金検索のハンドラクラスです。
 *
 * @reamsid_L DBD-4930-030 panxiaobo
 */
public class HikazeiNenkinKensakuHandler {

    private final HikazeiNenkinKensakuDiv div;
    private static final RString 改行 = new RString("\n");

    /**
     * コンストラクタです。
     *
     * @param div 【共有子Div】 1号一時差止ダイアログDiv
     */
    public HikazeiNenkinKensakuHandler(HikazeiNenkinKensakuDiv div) {
        this.div = div;
    }

    private enum 非課税年金検索キー {

        /**
         * 画面取得情報List
         */
        非課税年金検索;
    }

    /**
     * 画面初期化処理です。
     */
    public void onLoad() {
        HousholdFinder finder = HousholdFinder.createIntance();
        List<HousholdBusiness> 非課税年金検索 = finder.getLastInputHousehold(new FlexibleYear(div.getNendo()), new HihokenshaNo(div.getHihokenshaNo()), null, null, null, null);
        ViewStateHolder.put(非課税年金検索キー.非課税年金検索, new ArrayList(非課税年金検索));
        div.getTxtHihokenshano().setValue(div.getHihokenshaNo());
        div.getTxtTaishom().setValue(div.getNendo());
        div.getDgHikazeNenkinKensaku().setDataSource(createDateSource(非課税年金検索));

    }

    /**
     * 「選択」ボタンを押下します。
     *
     *
     */
    public void onClick_SelectedItem() {
        int index = div.getDgHikazeNenkinKensaku().getClickedRowId();
        ArrayList<HousholdBusiness> 非課税年金検索 = ViewStateHolder.get(非課税年金検索キー.非課税年金検索, ArrayList.class);
        div.setLastInputHousehold(DataPassingConverter.serialize(非課税年金検索.get(index)));
    }

    private List<dgHikazeNenkinKensaku_Row> createDateSource(List<HousholdBusiness> 非課税年金検索) {
        List<dgHikazeNenkinKensaku_Row> rowList = new ArrayList();
        dgHikazeNenkinKensaku_Row row = new dgHikazeNenkinKensaku_Row();
        for (int i = 0; i < 非課税年金検索.size(); i++) {
            RStringBuilder 氏名 = new RStringBuilder("");
            氏名.append(非課税年金検索.get(i).getカナ氏名()).append(改行).append(非課税年金検索.get(i).get漢字氏名());
            row.setTxtdtKanjiShimei(氏名.toRString());
            row.getTxtdtBirthday().setValue(new FlexibleDate(非課税年金検索.get(i).get生年月日()));
            row.setTxtdtSeibetsu(非課税年金検索.get(i).get性別());
            row.setTxtdtNenkinHokensha(非課税年金検索.get(i).get年金保険者());
            row.setTxtKisoNenkinNo(非課税年金検索.get(i).get基礎年金番号());
            row.setTxtGenKisoNenkinNo(非課税年金検索.get(i).get現基礎年金番号());
            row.setTxtNenkinCode(非課税年金検索.get(i).get年金コード());
            row.setTxtdtTaishoy(非課税年金検索.get(i).get対象年());
            row.getTxtdtSakuseiYMD().setValue(new FlexibleDate(非課税年金検索.get(i).get作成年月日()));
            row.setTxtdtTsuchiNaiyo(非課税年金検索.get(i).get通知内容());
            row.setTxtTorokuKubun(非課税年金検索.get(i).get登録区分());
            row.setId(i);
            rowList.add(row);
        }
        return rowList;
    }
}
