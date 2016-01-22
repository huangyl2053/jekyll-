/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5210001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiKaisaiKekka.ShinsakaiKaisaiYoteiJohoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiKaisaiKekka.ShinsakaiWariateIinJohoBusiness;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.core.shinsakai.IsShusseki;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.core.shinsakai.IssotaiUmu;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.core.shinsakai.KaigoninteiShinsakaiGichoKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Hoshu.GogitaichoKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsakai.IsChikokuUmu;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.Sikaku;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5210001.ShinsakaiKaisaiKekkaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5210001.dgShinsakaiIinIchiran_Row;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 *
 * 護認定審査会開催結果登録するクラスです
 *
 */
public class ShinsakaiKaisaiKekkaHandler {

    private final ShinsakaiKaisaiKekkaDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 介護認定審査会開催結果登録Div
     */
    public ShinsakaiKaisaiKekkaHandler(ShinsakaiKaisaiKekkaDiv div) {
        this.div = div;
    }

    /**
     * ShinsakaiKaisaiYoteiJohoBusiness 画面初期化表示、画面項目に設定されている値をクリアする。
     *
     * @param saiYoteiJoho ShinsakaiKaisaiYoteiJohoBusiness
     */
    public void onLoad(ShinsakaiKaisaiYoteiJohoBusiness saiYoteiJoho) {
        div.getTxtShinsakaiMeisho().setValue(saiYoteiJoho.get審査会名称());
        div.getTxtShinsakaiMeisho().setDisabled(true);
        div.getTxtGogitai().setValue(saiYoteiJoho.get合議体名称());
        div.getTxtGogitai().setDisabled(true);
        div.getTxtYoteiTeiin().setValue(new Decimal(saiYoteiJoho.get予定人数()));
        div.getTxtYoteiTeiin().setDisabled(true);
        div.getTxtJissiSu().setValue(new Decimal(saiYoteiJoho.get実施人数()));
        div.getTxtYoteiKaijo().setValue(saiYoteiJoho.get介護認定審査会開催場所名称());
        div.getTxtYoteiKaijo().setDisabled(true);
        div.getTxtKaisaiYoteibi().setValue(saiYoteiJoho.get開催予定日());
        div.getTxtKaisaiYoteibi().setDisabled(true);
        div.getTxtYoteiStartTime().setValue(RTime.parse(saiYoteiJoho.get予定開始時間()));
        div.getTxtYoteiStartTime().setDisabled(true);
        div.getTxtYoteiEndTime().setValue(RTime.parse(saiYoteiJoho.get予定終了時間()));
        div.getTxtYoteiEndTime().setDisabled(true);
        div.getTxtKaisaiBi().setValue(saiYoteiJoho.get開催日());
        div.getTxtKaisaiStartTime().setValue(strToTime(saiYoteiJoho.get開催開始時間()));
        div.getTxtKaisaiEndTime().setValue(strToTime(saiYoteiJoho.get開催終了時間()));
        div.getTxtShoyoTime().setValue(new RString(String.valueOf(saiYoteiJoho.get所要時間())));
//TODO 開催会場
//        div.getDdlKaisaiBasho().getDataSource();
//        div.getDdlKaisaiBasho().setSelectedKey(saiYoteiJoho.get開催会場());
    }

    /**
     * 画面初期化表示、画面項目に設定されている値をクリアする。
     *
     * @param list
     *
     */
    public void initialize(List<ShinsakaiWariateIinJohoBusiness> list) {
        List<dgShinsakaiIinIchiran_Row> dataGridList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            dgShinsakaiIinIchiran_Row row = new dgShinsakaiIinIchiran_Row();
            ShinsakaiWariateIinJohoBusiness business = list.get(i);
            row.getNumber().setValue(new Decimal(i + 1));
            row.setShinsakjaiIinCode(business.get審査会委員コード());
            row.setShimei(business.get介護認定審査会委員氏名().value());
            row.setSeibetsu(business.get性別() == null
                    ? RString.EMPTY : Seibetsu.toValue(business.get性別()).get名称());
            row.setShikaku(business.get介護認定審査員資格コード() == null
                    ? RString.EMPTY : Sikaku.toValue(business.get介護認定審査員資格コード().value()).get名称());
            row.setGogitaichoKubun(business.get合議体長区分コード() == null
                    ? RString.EMPTY : GogitaichoKubunCode.toValue(business.get合議体長区分コード().value()).get名称());
            row.getGichoKubun().setDataSource(setKaigoninteiShinsakaiGichoKubunCode());
            row.getGichoKubun().setSelectedKey(business.get介護認定審査会議長区分コード().value());
            row.getShukketsuKubun().setDataSource(setIsShusseki());
            row.getShukketsuKubun().setSelectedKey(new RString(String.valueOf(business.get委員出席())));
            row.getChikokuUmu().setDataSource(setIsChikokuUmu());
            row.getChikokuUmu().setSelectedKey(new RString(String.valueOf(business.get委員遅刻有無())));
            row.setShussekiTime(business.get委員出席時間());
            row.getSotaiUmu().setDataSource(setIssotaiUmu());
            row.getSotaiUmu().setSelectedKey(new RString(String.valueOf(business.get委員早退有無())));
            row.setTaisekiTime(business.get委員退席時間());
            dataGridList.add(row);
        }
        div.getDgShinsakaiIinIchiran().setDataSource(dataGridList);
    }

    /**
     * 介護認定審査会議長区分コードをクリアする。
     *
     */
    private List<KeyValueDataSource> setKaigoninteiShinsakaiGichoKubunCode() {
        List<KeyValueDataSource> kaigoninteiShinsakaiGichoKubunCode = new ArrayList<>();
        for (KaigoninteiShinsakaiGichoKubunCode gichoKubunCode : KaigoninteiShinsakaiGichoKubunCode.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource(gichoKubunCode.getコード(), gichoKubunCode.get名称());
            kaigoninteiShinsakaiGichoKubunCode.add(dataSource);
        }
        return kaigoninteiShinsakaiGichoKubunCode;
    }

    /**
     * 委員出席をクリアする。
     *
     */
    private List<KeyValueDataSource> setIsShusseki() {
        List<KeyValueDataSource> Shusseki = new ArrayList<>();
        for (IsShusseki isShusseki : IsShusseki.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource(new RString(String.valueOf(isShusseki.getコード())), isShusseki.get名称());
            Shusseki.add(dataSource);
        }
        return Shusseki;
    }

    /**
     * 委員早退有無をクリアする。
     *
     */
    private List<KeyValueDataSource> setIssotaiUmu() {
        List<KeyValueDataSource> sotaiUmu = new ArrayList<>();
        for (IssotaiUmu issotaiUmu : IssotaiUmu.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource(new RString(String.valueOf(issotaiUmu.getコード())), issotaiUmu.get名称());
            sotaiUmu.add(dataSource);
        }
        return sotaiUmu;
    }

    /**
     * 員遅刻有無をクリアする。
     *
     */
    private List<KeyValueDataSource> setIsChikokuUmu() {
        List<KeyValueDataSource> chikokuUmu = new ArrayList<>();
        for (IsChikokuUmu isChikokuUmu : IsChikokuUmu.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource(new RString(String.valueOf(isChikokuUmu.getコード())), isChikokuUmu.get名称());
            chikokuUmu.add(dataSource);
        }
        return chikokuUmu;
    }

    private RTime strToTime(RString str) {
        if (str == null) {
            return RDateTime.MIN.getTime();
        }
        str = str.insert(2, ":");
        return RTime.parse(str);
    }
}
