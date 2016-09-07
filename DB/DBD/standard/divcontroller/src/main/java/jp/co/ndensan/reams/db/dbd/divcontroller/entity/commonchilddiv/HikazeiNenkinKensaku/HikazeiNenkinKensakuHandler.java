/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.HikazeiNenkinKensaku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.houshold.HousholdBusiness;
import jp.co.ndensan.reams.db.dbd.definition.core.hikazeinenkin.TorokuKubun;
import jp.co.ndensan.reams.db.dbd.service.core.houshold.HousholdFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 【共有子Div】非課税年金検索のハンドラクラスです。
 *
 * @reamsid_L DBD-4930-030 panxiaobo
 */
public class HikazeiNenkinKensakuHandler {

    private final HikazeiNenkinKensakuDiv div;
    private static final RString 改行 = new RString("\n");
    private final RString 性別_男 = new RString("1");
    private final RString 性別_女 = new RString("2");
    private final RString 男 = new RString("男");
    private final RString 女 = new RString("女");
    private final RString 処理区分_年次処理 = new RString("11");
    private final RString 処理区分_月次処理 = new RString("12");
    private final RString 年次処理 = new RString("年次処理");
    private final RString 月次処理 = new RString("月次処理");

    /**
     * コンストラクタです。
     *
     * @param div 【共有子Div】 非課税年金検索ダイアログDiv
     */
    public HikazeiNenkinKensakuHandler(HikazeiNenkinKensakuDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     * @return 非課税年金検索
     */
    public List<HousholdBusiness> onLoad() {
        HousholdFinder finder = HousholdFinder.createIntance();
        List<HousholdBusiness> 非課税年金検索 = finder
                .getLastInputHousehold(new FlexibleYear(div.getNendo()), new HihokenshaNo(div.getHihokenshaNo()), null, null, null, null);
        div.getTxtHihokenshano().setValue(div.getHihokenshaNo());
        div.getTxtTaishom().setValue(div.getNendo());
        div.getDgHikazeNenkinKensaku().setDataSource(createDateSource(非課税年金検索));
        return 非課税年金検索;

    }

    /**
     * 「選択」ボタンを押下します。
     *
     * @param 非課税年金検索 非課税年金検索
     */
    public void onClick_SelectedItem(ArrayList<HousholdBusiness> 非課税年金検索) {
        int index = div.getDgHikazeNenkinKensaku().getClickedRowId();
        div.setLastInputHousehold(DataPassingConverter.serialize(非課税年金検索.get(index)));
    }

    private List<dgHikazeNenkinKensaku_Row> createDateSource(List<HousholdBusiness> 非課税年金検索) {
        List<dgHikazeNenkinKensaku_Row> rowList = new ArrayList();
        for (int i = 0; i < 非課税年金検索.size(); i++) {
            dgHikazeNenkinKensaku_Row row = new dgHikazeNenkinKensaku_Row();
            RStringBuilder 氏名 = new RStringBuilder("");
            氏名.append(非課税年金検索.get(i).getカナ氏名()).append(改行).append(非課税年金検索.get(i).get漢字氏名());
            row.setTxtdtKanjiShimei(氏名.toRString());
            row.getTxtdtBirthday().setValue(new FlexibleDate(非課税年金検索.get(i).get生年月日()));
            if (性別_男.equals(非課税年金検索.get(i).get性別())) {
                row.setTxtdtSeibetsu(男);
            } else if (性別_女.equals(非課税年金検索.get(i).get性別())) {
                row.setTxtdtSeibetsu(女);
            }
            row.setTxtdtNenkinHokensha(非課税年金検索.get(i).get年金保険者());
            row.setTxtKisoNenkinNo(非課税年金検索.get(i).get基礎年金番号());
            row.setTxtGenKisoNenkinNo(非課税年金検索.get(i).get現基礎年金番号());
            row.setTxtNenkinCode(非課税年金検索.get(i).get年金コード());
            row.setTxtdtTaishoy(非課税年金検索.get(i).get対象年());
            row.getTxtdtSakuseiYMD().setValue(new FlexibleDate(非課税年金検索.get(i).get作成年月日()));
            if (処理区分_年次処理.equals(非課税年金検索.get(i).get通知内容())) {
                row.setTxtdtTsuchiNaiyo(年次処理);
            } else if (処理区分_月次処理.equals(非課税年金検索.get(i).get通知内容())) {
                row.setTxtdtTsuchiNaiyo(月次処理);
            }
            if (!非課税年金検索.get(i).get登録区分().isNullOrEmpty()) {
                row.setTxtTorokuKubun(TorokuKubun.toValue(非課税年金検索.get(i).get登録区分()).get名称());
            }
            row.setId(i);
            rowList.add(row);
        }
        return rowList;
    }
}
