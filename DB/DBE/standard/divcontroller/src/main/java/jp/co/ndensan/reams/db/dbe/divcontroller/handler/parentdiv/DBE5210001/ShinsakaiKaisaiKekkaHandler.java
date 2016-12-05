/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5210001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaikaisaikekka.ShinsakaiKaisaiYoteiJohoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaikaisaikekka.ShinsakaiWariateIinJohoBusiness;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.KaigoninteiShinsakaiGichoKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.core.hoshu.GogitaichoKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.IsChikokuUmu;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.IsShusseki;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.IssotaiUmu;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5210001.ShinsakaiKaisaiKekkaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5210001.dgShinsakaiIinIchiran_Row;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.Sikaku;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 介護認定審査会開催結果登録するクラスです。
 *
 * @reamsid_L DBE-0160-010 wangxiaodong
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
     * 画面初期化表示、画面項目に設定されている値をクリアです。
     *
     * @param saiYoteiJoho ヘッドエリア内容
     */
    public void onLoad(List<ShinsakaiKaisaiYoteiJohoBusiness> saiYoteiJoho) {
        for (int i = 0; i < saiYoteiJoho.size(); i++) {
            ShinsakaiKaisaiYoteiJohoBusiness business = saiYoteiJoho.get(i);
            div.getTxtShinsakaiMeisho().setValue(business.get審査会名称());
            div.setGogitaiNo(new RString(String.valueOf(business.get合議体番号())));
            div.getTxtGogitai().setValue(business.get合議体名称());
            div.getTxtYoteiTeiin().setValue(new Decimal(business.get予定人数()));
            div.getShinsakaiKaisaiInfo().getTxtJissiSu().setValue(new Decimal(business.get実施人数()));
            div.getTxtYoteiKaijo().setValue(business.get介護認定審査会開催場所名称());
            div.getTxtKaisaiYoteibi().setValue(business.get開催予定日());
            div.getTxtYoteiStartTime().setValue(strToTime(business.get予定開始時間()));
            div.getTxtYoteiEndTime().setValue(strToTime(business.get予定終了時間()));
            div.getShinsakaiKaisaiInfo().getTxtKaisaiBi().setValue(business.get開催日());
            div.getShinsakaiKaisaiInfo().getTxtKaisaiStartTime().setValue(strToTime(business.get開催開始時間()));
            div.getShinsakaiKaisaiInfo().getTxtKaisaiEndTime().setValue(strToTime(business.get開催終了時間()));
            div.getShinsakaiKaisaiInfo().getTxtShoyoTime().setValue(new RString(String.valueOf(business.get所要時間())));
            if (business.get開催会場() != null) {
                div.getShinsakaiKaisaiInfo().getDdlKaisaiBasho().setSelectedKey(business.get開催会場());
            }
        }
        if (div.getShinsakaiKaisaiInfo().getTxtKaisaiBi().getValue() == null || div.getShinsakaiKaisaiInfo().getTxtKaisaiBi().getValue().isEmpty()) {
            div.setModel(new RString("新規モード"));
        } else {
            div.setModel(new RString("更新モード"));
        }
    }

    /**
     * ヘッドエリア内容の状態設定です。
     *
     */
    public void setDisabled() {
        div.getTxtShinsakaiMeisho().setDisabled(true);
        div.getTxtGogitai().setDisabled(true);
        div.getTxtYoteiTeiin().setDisabled(true);
        div.getTxtYoteiKaijo().setDisabled(true);
        div.getTxtKaisaiYoteibi().setDisabled(true);
        div.getTxtYoteiStartTime().setDisabled(true);
        div.getTxtYoteiEndTime().setDisabled(true);
    }

    /**
     * 画面初期化表示、画面項目に設定されている値をクリアです。
     *
     * @param list 審査会委員一覧設定
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
            row.setShimei(business.get介護認定審査会委員氏名().value());
            row.setSeibetsu(business.get性別() == null ? RString.EMPTY : Seibetsu.toValue(business.get性別()).get名称());
            row.setShikaku(business.get介護認定審査員資格コード() == null
                    ? RString.EMPTY : Sikaku.toValue(business.get介護認定審査員資格コード().value()).get名称());
            row.setGogitaichoKubun(business.get合議体長区分コード() == null
                    ? RString.EMPTY : GogitaichoKubunCode.toValue(business.get合議体長区分コード().value()).get名称());
            row.getGichoKubun().setDataSource(setKaigoninteiShinsakaiGichoKubunCode());
            row.getGichoKubun().setSelectedKey(business.get介護認定審査会議長区分コード().value());
            row.getShukketsuKubun().setDataSource(setIsShusseki());
            row.getShukketsuKubun().setSelectedKey(new RString(String.valueOf(business.is委員出席())));
            row.getChikokuUmu().setDataSource(setIsChikokuUmu());
            row.getChikokuUmu().setSelectedKey(new RString(String.valueOf(business.is委員遅刻有無())));
            row.getShussekiTime().setValue(strToTime(business.get委員出席時間()));
            row.getShussekiTime().setDisabled(Boolean.TRUE);
            row.getSotaiUmu().setDataSource(setIssotaiUmu());
            row.getSotaiUmu().setSelectedKey(new RString(String.valueOf(business.is委員早退有無())));
            row.getTaisekiTime().setValue(strToTime(business.get委員退席時間()));
            row.getTaisekiTime().setDisabled(Boolean.TRUE);
            dataGridList.add(row);
        }
        div.getDgShinsakaiIinIchiran().setDataSource(dataGridList);
    }

    private List<KeyValueDataSource> setKaigoninteiShinsakaiGichoKubunCode() {
        List<KeyValueDataSource> shinsakaiGichoKubunCode = new ArrayList<>();
        for (KaigoninteiShinsakaiGichoKubunCode gichoKubunCode : KaigoninteiShinsakaiGichoKubunCode.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource(gichoKubunCode.getコード(), gichoKubunCode.get名称());
            shinsakaiGichoKubunCode.add(dataSource);
        }
        return shinsakaiGichoKubunCode;
    }

    private List<KeyValueDataSource> setIsShusseki() {
        List<KeyValueDataSource> shusseki = new ArrayList<>();
        for (IsShusseki isShusseki : IsShusseki.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource(new RString(String.valueOf(isShusseki.is委員出席())), isShusseki.get名称());
            shusseki.add(dataSource);
        }
        return shusseki;
    }

    private List<KeyValueDataSource> setIssotaiUmu() {
        List<KeyValueDataSource> sotaiUmu = new ArrayList<>();
        KeyValueDataSource dataSource = new KeyValueDataSource(new RString(String.valueOf(IssotaiUmu.早退なし.is委員早退())), RString.EMPTY);
        sotaiUmu.add(dataSource);
        KeyValueDataSource dataSource1 = new KeyValueDataSource(new RString(String.valueOf(IssotaiUmu.早退.is委員早退())), IssotaiUmu.早退.get名称());
        sotaiUmu.add(dataSource1);
        return sotaiUmu;
    }

    private List<KeyValueDataSource> setIsChikokuUmu() {
        List<KeyValueDataSource> chikokuUmu = new ArrayList<>();
        KeyValueDataSource dataSource = new KeyValueDataSource(new RString(String.valueOf(IsChikokuUmu.遅刻なし.is委員遅刻())), RString.EMPTY);
        chikokuUmu.add(dataSource);
        KeyValueDataSource dataSource1 = new KeyValueDataSource(new RString(String.valueOf(IsChikokuUmu.遅刻.is委員遅刻())), IsChikokuUmu.遅刻.get名称());
        chikokuUmu.add(dataSource1);
        return chikokuUmu;
    }

    private RTime strToTime(RString str) {
        if (str == null || str.isEmpty()) {
            return RDateTime.MIN.getTime();
        }
        return new RTime(str);
    }
}
