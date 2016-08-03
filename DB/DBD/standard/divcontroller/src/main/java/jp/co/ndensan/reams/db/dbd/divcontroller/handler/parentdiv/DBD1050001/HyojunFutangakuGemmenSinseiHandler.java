/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1050001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.hyojunfutangakugemmen.HyojunFutangakuGemmen;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.hyojunfutangakugemmen.GengakuKubun;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1050001.HyojunFutanGemmenDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1050001.dgShinseiIchiran_Row;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.hyojunfutangakugemmen.HyojunFutangakuGemmenService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 標準負担額減免申請ハンドラクラスです。
 *
 * @reamsid_L DBD-3700-010 liuwei2
 */
public class HyojunFutangakuGemmenSinseiHandler {

    /**
     * get標準負担額減免申請データ取得処理です。
     *
     * @param 被保険者番号 被保険者番号
     * @return 申請一覧情報
     */
    public List<HyojunFutangakuGemmen> get標準負担額減免申請情報(HihokenshaNo 被保険者番号) {
        return new HyojunFutangakuGemmenService().select標準負担額減免申請情報(被保険者番号);
    }

    /**
     * 標準負担額減免申請画面のShinseiDetail処理です。
     *
     * @param div {@link HyojunFutanGemmenDiv 標準負担額減免申請画面Div}
     * @return ResponseData
     */
    public ResponseData onload(HyojunFutanGemmenDiv div) {
        ResponseData response = new ResponseData<>();

        setDataSource(div.getShinseiDetail().getRadKetteiKubun().getDataSource(),
                new RString("key0"), new RString("承認しない"));
        setDataSource(div.getShinseiDetail().getRadKetteiKubun().getDataSource(),
                new RString("key1"), new RString("承認する"));

        setDataSource(div.getShinseiDetail().getDdlGengakuKubun().getDataSource(),
                new RString("key0"), new RString("市町村民税非課税"));
        setDataSource(div.getShinseiDetail().getDdlGengakuKubun().getDataSource(),
                new RString("key1"), new RString("老齢福祉年金受給"));
        setDataSource(div.getShinseiDetail().getDdlGengakuKubun().getDataSource(),
                new RString("key2"), new RString("その他"));

        setDataSource(div.getShinseiDetail().getDdlShinseiRiyu().getDataSource(),
                new RString("key0"), new RString("世帯非課税８０万以下"));
        setDataSource(div.getShinseiDetail().getDdlShinseiRiyu().getDataSource(),
                new RString("key1"), new RString("世帯非課税８０万超"));
        setDataSource(div.getShinseiDetail().getDdlShinseiRiyu().getDataSource(),
                new RString("key2"), new RString("生保"));
        setDataSource(div.getShinseiDetail().getDdlShinseiRiyu().getDataSource(),
                new RString("key3"), new RString("世帯非課税"));
        setDataSource(div.getShinseiDetail().getDdlShinseiRiyu().getDataSource(),
                new RString("key4"), new RString("老齢"));
        setDataSource(div.getShinseiDetail().getDdlShinseiRiyu().getDataSource(),
                new RString("key5"), new RString("特例減額措置"));
        setDataSource(div.getShinseiDetail().getDdlShinseiRiyu().getDataSource(),
                new RString("key6"), new RString("その他"));
        return response;
    }

    private void setDataSource(List<KeyValueDataSource> dataSource,
            RString keyNum, RString keyValues) {
        KeyValueDataSource data = new KeyValueDataSource(keyNum, keyValues);
        dataSource.add(data);
    }

    /**
     * 申請一覧情報データ処理です。
     *
     * @param 標準負担額減免情報データ 標準負担額減免情報データ
     * @return 最初申請一覧情報
     */
    public ArrayList<dgShinseiIchiran_Row> setDgShinseiIchiran_Row(List<HyojunFutangakuGemmen> 標準負担額減免情報データ) {
        ArrayList<dgShinseiIchiran_Row> 最初申請一覧情報 = new ArrayList<>();
        for (HyojunFutangakuGemmen dbT4012HyojunFutangakuGemmen : 標準負担額減免情報データ) {
            dgShinseiIchiran_Row hyojunFutangakuGemmen = new dgShinseiIchiran_Row();
            hyojunFutangakuGemmen.setTxtShinseiYMD(new RString(dbT4012HyojunFutangakuGemmen.get申請年月日().toString()));
            hyojunFutangakuGemmen.setTxtShinseiRiyu(dbT4012HyojunFutangakuGemmen.get申請事由());
            TextBoxFlexibleDate 決定年月日 = new TextBoxFlexibleDate();
            決定年月日.setValue(new FlexibleDate(dbT4012HyojunFutangakuGemmen.get決定年月日().toString()));
            hyojunFutangakuGemmen.setTxtKetteiYMD(決定年月日);
            if (dbT4012HyojunFutangakuGemmen.get決定区分().equals(KetteiKubun.承認しない.getコード())) {
                hyojunFutangakuGemmen.setTxtKetteiKubun(KetteiKubun.承認しない.get名称());
            } else {
                hyojunFutangakuGemmen.setTxtKetteiKubun(KetteiKubun.承認する.get名称());
            }
            if (dbT4012HyojunFutangakuGemmen.get減額後金額() == null) {
                hyojunFutangakuGemmen.setTxtHyojunFutangaku(RString.EMPTY);
            } else {
                hyojunFutangakuGemmen.setTxtHyojunFutangaku(new RString(dbT4012HyojunFutangakuGemmen.get減額後金額().toString()));
            }

            if (dbT4012HyojunFutangakuGemmen.get減額区分() == null) {
                hyojunFutangakuGemmen.setTxtGengakuKubun(RString.EMPTY);
            } else {
                RString 減額区分 = dbT4012HyojunFutangakuGemmen.get減額区分();
                if (減額区分.equals(new RString("市町"))) {
                    hyojunFutangakuGemmen.setTxtGengakuKubun(GengakuKubun.市町村民税非課税.get名称());
                } else if (減額区分.equals(new RString("老齢"))) {
                    hyojunFutangakuGemmen.setTxtGengakuKubun(GengakuKubun.老齢福祉年金受給.get名称());
                } else {
                    hyojunFutangakuGemmen.setTxtGengakuKubun(GengakuKubun.その他.get名称());
                }
            }
            hyojunFutangakuGemmen.getTxtTekiyoYMD().setValue(new FlexibleDate(dbT4012HyojunFutangakuGemmen.get適用開始年月日().toString()));
            hyojunFutangakuGemmen.getTxtYukoKigen().setValue(new FlexibleDate(dbT4012HyojunFutangakuGemmen.get適用終了年月日().toString()));

            if (dbT4012HyojunFutangakuGemmen.get非承認理由() == null) {
                hyojunFutangakuGemmen.setTxtShoninShinaiRiyu(RString.EMPTY);
            } else {
                hyojunFutangakuGemmen.setTxtShoninShinaiRiyu(dbT4012HyojunFutangakuGemmen.get非承認理由());
            }

            最初申請一覧情報.add(hyojunFutangakuGemmen);
        }
        return 最初申請一覧情報;
    }

    /**
     * 申請一覧情報データ処理です。
     *
     * @param dgShinseiIchiran_Row　選ばれた情報
     * @param List<HyojunFutangakuGemmen>　申請一覧情報
     * @return　HyojunFutangakuGemmen
     */
    public HyojunFutangakuGemmen get該当Joho(dgShinseiIchiran_Row row, List<HyojunFutangakuGemmen> dbDatalist) {
        if (dbDatalist != null) {
            for (HyojunFutangakuGemmen joho : dbDatalist) {
                if (new RString(joho.get申請年月日().toString()).equals(row.getTxtShinseiYMD())
                        && joho.get申請事由().equals(row.getTxtShinseiRiyu())) {
                    return joho;
                }
            }
        }
        return null;
    }
}
