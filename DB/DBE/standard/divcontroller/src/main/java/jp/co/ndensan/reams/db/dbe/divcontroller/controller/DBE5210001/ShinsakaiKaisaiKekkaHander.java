/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.DBE5210001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaikaisaikekkajoho.ShinsakaiKaisaiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaiwariateiinjoho.ShinsakaiWariateIinJoho;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5210001.ShinsakaiKaisaiKekkaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5210001.dgShinsakaiIinIchiran_Row;
import jp.co.ndensan.reams.db.dbe.service.core.DBE5210001.IsChikokuUmu;
import jp.co.ndensan.reams.db.dbe.service.core.DBE5210001.IsShusseki;
import jp.co.ndensan.reams.db.dbe.service.core.DBE5210001.IssotaiUmu;
import jp.co.ndensan.reams.db.dbe.service.core.DBE5210001.KaigoninteiShinsakaiGichoKubunCode;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJohoManager;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 *
 * 護認定審査会開催結果登録するクラスです
 *
 */
public class ShinsakaiKaisaiKekkaHander {

    private final ShinsakaiKaisaiKekkaDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 介護認定審査会開催結果登録Div
     */
    public ShinsakaiKaisaiKekkaHander(ShinsakaiKaisaiKekkaDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化表示、画面項目に設定されている値をクリアする。
     */
    public void onLoad() {
        ShinsakaiKaisaiYoteiJohoManager YoteiJohoManager = ShinsakaiKaisaiYoteiJohoManager.createInstance();
        ShinsakaiKaisaiYoteiJoho saiYoteiJoho = YoteiJohoManager.getヘッドエリア内容検索(null);
        ShinsakaiKaisaiKekkaJoho JohoList = saiYoteiJoho.getShinsakaiKaisaiKekkaJohoList().get(0);
        RStringBuilder rsbuilder = new RStringBuilder();
        rsbuilder.append("第");
        rsbuilder.append(saiYoteiJoho.get介護認定審査会開催番号());
        rsbuilder.append("回審査会");
        div.getTxtShinsakaiMeisho().setValue(rsbuilder.toRString());
        div.getTxtShinsakaiMeisho().setDisabled(true);
        //div.getTxtGogitai().setValue(saiYoteiJoho.gogitaiMei);//合議体名称
        div.getTxtGogitai().setDisabled(true);
        div.getTxtYoteiTeiin().setValue(new Decimal(saiYoteiJoho.get介護認定審査会割当済み人数()));
        div.getTxtYoteiTeiin().setDisabled(true);
        div.getTxtJissiSu().setValue(new Decimal(JohoList.get介護認定審査会実施人数()));
        // div.getTxtYoteiKaijo().setValue(saiYoteiJoho);//予定会場
        div.getTxtYoteiKaijo().setDisabled(true);
        div.getTxtKaisaiYoteibi().setValue(new FlexibleDate(saiYoteiJoho.get介護認定審査会開催予定年月日().wareki().toDateString()));
        div.getTxtKaisaiYoteibi().setDisabled(true);
        div.getTxtYoteiStartTime().setValue(RTime.parse(saiYoteiJoho.get介護認定審査会開始予定時刻()));
        div.getTxtYoteiStartTime().setDisabled(true);
        div.getTxtYoteiEndTime().setValue(RTime.parse(saiYoteiJoho.get介護認定審査会終了予定時刻()));
        div.getTxtYoteiEndTime().setDisabled(true);
        div.getTxtKaisaiBi().setValue(new FlexibleDate(JohoList.get介護認定審査会開催年月日().wareki().toDateString()));
        div.getTxtKaisaiStartTime().setValue(RTime.parse(JohoList.get介護認定審査会開始時刻()));
        div.getTxtKaisaiEndTime().setValue(RTime.parse(JohoList.get介護認定審査会終了時刻()));
        div.getTxtShoyoTime().setValue(new RString(String.valueOf(JohoList.get所要時間合計())));
        div.getDdlKaisaiBasho().setSelectedKey(JohoList.get介護認定審査会開催場所コード());
    }

    /**
     * 画面初期化表示、画面項目に設定されている値をクリアする。
     *
     * @param list
     *
     * @return dataGridList
     */
    public List<dgShinsakaiIinIchiran_Row> initialize(List<ShinsakaiKaisaiYoteiJoho> list) {
        List<dgShinsakaiIinIchiran_Row> dataGridList = new ArrayList<>();

        for (int i = 0; i < dataGridList.size(); i++) {
            dataGridList.get(i);
        }
        for (ShinsakaiKaisaiYoteiJoho yoteiJoho : list) {
            ShinsakaiWariateIinJoho shinsakaiWariateIinJoho = yoteiJoho.getShinsakaiWariateIinJohoList().get(0);
            dgShinsakaiIinIchiran_Row ShinsakaiIinIchiran_Row = new dgShinsakaiIinIchiran_Row();
            //ShinsakaiIinIchiran_Row.setNumber("1");
            ShinsakaiIinIchiran_Row.setShinsakjaiIinCode(shinsakaiWariateIinJoho.get介護認定審査会委員コード());
            ShinsakaiIinIchiran_Row.setShimei(shinsakaiWariateIinJoho.getShinsakaiIinJohoList().get(0).get介護認定審査会委員氏名().value());
            //ShinsakaiIinIchiran_Row.setSeibetsu(Seibetsu.toValue(RString.EMPTY));
            ShinsakaiIinIchiran_Row.setShikaku(shinsakaiWariateIinJoho.getShinsakaiIinJohoList().get(0).get介護認定審査員資格コード().value());
            //ShinsakaiIinIchiran_Row.setGogitaichoKubun(yoteiJoho.getShinsakaiWariateIinJohoList().get(0).getShinsakaiIinJohoList().get(0).);
            List<KeyValueDataSource> KaigoninteiShinsakaiGichoKubunCodeList = new ArrayList();
            KaigoninteiShinsakaiGichoKubunCodeList.add(new KeyValueDataSource(KaigoninteiShinsakaiGichoKubunCode.委員.getコード(), KaigoninteiShinsakaiGichoKubunCode.委員.get名称()));
            KaigoninteiShinsakaiGichoKubunCodeList.add(new KeyValueDataSource(KaigoninteiShinsakaiGichoKubunCode.議長.getコード(), KaigoninteiShinsakaiGichoKubunCode.議長.get名称()));
            ShinsakaiIinIchiran_Row.getGichoKubun().setDataSource(KaigoninteiShinsakaiGichoKubunCodeList);
            ShinsakaiIinIchiran_Row.getGichoKubun().setSelectedKey(new RString(String.valueOf(shinsakaiWariateIinJoho.get介護認定審査会議長区分コード())));
            List<KeyValueDataSource> IsShussekiList = new ArrayList();
            IsShussekiList.add(new KeyValueDataSource(new RString(String.valueOf(IsShusseki.出席.getコード())), IsShusseki.出席.get名称()));
            IsShussekiList.add(new KeyValueDataSource(new RString(String.valueOf(IsShusseki.欠席.getコード())), IsShusseki.欠席.get名称()));
            ShinsakaiIinIchiran_Row.getShukketsuKubun().setDataSource(IsShussekiList);
            ShinsakaiIinIchiran_Row.getShukketsuKubun().setSelectedKey(new RString(String.valueOf(shinsakaiWariateIinJoho.get委員出席())));
            List<KeyValueDataSource> IsChikokuUmuList = new ArrayList();
            IsChikokuUmuList.add(new KeyValueDataSource(new RString(String.valueOf(IsChikokuUmu.遅刻.getコード())), IsChikokuUmu.遅刻.get名称()));
            IsChikokuUmuList.add(new KeyValueDataSource(new RString(String.valueOf(IsChikokuUmu.遅刻なし.getコード())), IsChikokuUmu.遅刻なし.get名称()));
            ShinsakaiIinIchiran_Row.getChikokuUmu().setDataSource(IsChikokuUmuList);
            ShinsakaiIinIchiran_Row.getChikokuUmu().setSelectedKey(new RString(String.valueOf(shinsakaiWariateIinJoho.get委員遅刻有無())));
            ShinsakaiIinIchiran_Row.setShussekiTime(shinsakaiWariateIinJoho.get委員出席時間());
            List<KeyValueDataSource> IssotaiUmuList = new ArrayList();
            IssotaiUmuList.add(new KeyValueDataSource(new RString(String.valueOf(IssotaiUmu.早退.getコード())), IssotaiUmu.早退.get名称()));
            IssotaiUmuList.add(new KeyValueDataSource(new RString(String.valueOf(IssotaiUmu.早退なし.getコード())), IssotaiUmu.早退なし.get名称()));
            ShinsakaiIinIchiran_Row.getSotaiUmu().setDataSource(IssotaiUmuList);
            ShinsakaiIinIchiran_Row.getSotaiUmu().setSelectedKey(new RString(String.valueOf(shinsakaiWariateIinJoho.get委員早退有無())));
            ShinsakaiIinIchiran_Row.setTaisekiTime(shinsakaiWariateIinJoho.get委員退席時間());
            dataGridList.add(ShinsakaiIinIchiran_Row);
        }
        return dataGridList;
    }

    /**
     * 介護認定審査会結果情報更新処理をセットする
     */
    public void onClick_介護認定審査会開催結果情報() {
        div.getTxtShinsakaiMeisho().setValue(div.getTxtShinsakaiMeisho().getValue());
        div.getTxtGogitai().setValue(div.getTxtGogitai().getValue());
        div.getTxtKaisaiBi().setValue(div.getTxtKaisaiBi().getValue());
        div.getTxtYoteiStartTime().setValue(div.getTxtYoteiStartTime().getValue());
        div.getTxtKaisaiEndTime().setValue(div.getTxtKaisaiEndTime().getValue());
        div.getTxtYoteiKaijo().setValue(div.getTxtYoteiKaijo().getValue());
        div.getTxtShoyoTime().setValue(div.getTxtShoyoTime().getValue());
        div.getTxtJissiSu().setValue(div.getTxtJissiSu().getValue());
    }

    /**
     * 介護認定審査会割当委員情報をセットする
     */
    public void onClick_介護認定審査会割当委員情報() {
        dgShinsakaiIinIchiran_Row row = new dgShinsakaiIinIchiran_Row();
        div.getShinsakaiIinToroku().getDgShinsakaiIinIchiran().getClickedItem().getSeibetsu();
        row.setShinsakjaiIinCode(div.getShinsakaiIinToroku().getDgShinsakaiIinIchiran().getClickedItem().getShinsakjaiIinCode());
        div.getTxtKaisaiBi().setValue(div.getTxtKaisaiBi().getValue());
        row.setGichoKubun(div.getShinsakaiIinToroku().getDgShinsakaiIinIchiran().getClickedItem().getChikokuUmu());
        row.setShukketsuKubun(div.getShinsakaiIinToroku().getDgShinsakaiIinIchiran().getClickedItem().getShukketsuKubun());
        row.setChikokuUmu(div.getShinsakaiIinToroku().getDgShinsakaiIinIchiran().getClickedItem().getChikokuUmu());
        row.setShussekiTime(div.getShinsakaiIinToroku().getDgShinsakaiIinIchiran().getClickedItem().getShussekiTime());
        row.setSotaiUmu(div.getShinsakaiIinToroku().getDgShinsakaiIinIchiran().getClickedItem().getSotaiUmu());
        row.setTaisekiTime(div.getShinsakaiIinToroku().getDgShinsakaiIinIchiran().getClickedItem().getTaisekiTime());
    }
}
