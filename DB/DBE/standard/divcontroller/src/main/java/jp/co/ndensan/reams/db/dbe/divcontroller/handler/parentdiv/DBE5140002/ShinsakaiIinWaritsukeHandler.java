/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5140002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinwaritsuke.ShinsakaiKaisaiYoteiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinwaritsuke.ShinsakaiiinJoho;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Hoshu.GogitaichoKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsakai.IsGogitaiDummy;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsakai.IsGogitaiSeishinkaSonzai;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsakai.IsShusseki;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.IsHaishi;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.Sikaku;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5140002.ShinsakaiIinWaritsukeDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5140002.dgShinsakaiIinIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5140002.dgShinsakaiIinKoseiIchiran_Row;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 介護認定審査会割当委員情報のHandlerクラスです。
 */
public class ShinsakaiIinWaritsukeHandler {

    private static final RString 介護認定審査会の前 = new RString("第");
    private static final RString 介護認定審査会の後 = new RString("回審査会");
    private static final RString SELECTEDKEY = new RString("key0");
    private boolean different = true;
    private final ShinsakaiIinWaritsukeDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public ShinsakaiIinWaritsukeHandler(ShinsakaiIinWaritsukeDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     * @param saiYoteiJoho ヘッドエリア内容
     */
    public void onLoad(List<ShinsakaiKaisaiYoteiJoho> saiYoteiJoho) {
        List<RString> chkDummyKubunlist = new ArrayList<>();
        List<RString> chkSeishinkailist = new ArrayList<>();
        ShinsakaiKaisaiYoteiJoho business = saiYoteiJoho.get(0);
        RStringBuilder builder = new RStringBuilder();
        builder.append(介護認定審査会の前);
        builder.append(ViewStateHolder.get(ViewStateKeys.介護認定審査会委員割付_開催番号, RString.class));
        builder.append(介護認定審査会の後);
        div.getTxtKaigoNinteiShinsakai().setValue(builder.toRString());
        div.getTxtGogitai().setValue(nullToEmpty(business.get合議体()));
        div.getTxtKaishiYoteiTime().setValue(new RTime(nullToEmpty(business.get開始予定時間())));
        if (IsGogitaiDummy.toValue(business.isダミー区分()).getコード()) {
            chkDummyKubunlist.add(SELECTEDKEY);
        }
        div.getChkDummyKubun().setSelectedItemsByKey(chkDummyKubunlist);
        div.getTxtKaisaiYoteibi().setValue(new RDate(new RDate(nullToEmpty(business.get開催予定日())
                .toString()).wareki().toDateString().toString()));
        div.getTxtKaisaiBasho().setValue(nullToEmpty(business.get開催場所()));
        div.getTxtShuryoYoteiTime().setValue(new RTime(nullToEmpty(business.get終了予定時間())));
        div.getTxtYoteiTeiin().setValue(new RString(String.valueOf(business.get予定定員())));
        if (IsGogitaiSeishinkaSonzai.toValue(business.is精神科医()).getコード()) {
            chkSeishinkailist.add(SELECTEDKEY);
        }
        div.getChkSeishinkai().setSelectedItemsByKey(chkSeishinkailist);
    }

    /**
     * 介護認定審査会委員(構成)一覧gridエリア。
     *
     * @param list 一覧エリア内容
     */
    public void setDataGrid(List<ShinsakaiiinJoho> list) {
        List<dgShinsakaiIinKoseiIchiran_Row> koseiIchiranGridList = new ArrayList<>();
        List<dgShinsakaiIinIchiran_Row> ichiranGridList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            ShinsakaiiinJoho business = list.get(i);
            if (business.is補欠区分()) {
                set一覧DataGrid(ichiranGridList, business);
            } else {
                dgShinsakaiIinKoseiIchiran_Row koseiIchiran_Row = new dgShinsakaiIinKoseiIchiran_Row();
                koseiIchiran_Row.setShinsakaiIinCode(nullToEmpty(business.get介護認定審査会委員コード()));
                koseiIchiran_Row.setShinsakaiIinName(nullToEmpty(business.get介護認定審査会委員氏名()));
                koseiIchiran_Row.setShozokuKikan(nullToEmpty(business.get所属機関()));
                koseiIchiran_Row.setSex(Seibetsu.toValue(nullToEmpty(business.get性別())).get名称());
                koseiIchiran_Row.setShinsakaiInnShikaku(Sikaku.toValue(
                        nullToEmpty(business.get介護認定審査会委員資格())).get名称());
                koseiIchiran_Row.setGogitaichoKubun(GogitaichoKubunCode.toValue(
                        nullToEmpty(business.get合議体長区分())).get名称());
                koseiIchiran_Row.setShukketsuKubun(IsShusseki.出席.get名称());
                koseiIchiran_Row.setHaishiFlag(IsHaishi.toValue(business.is廃止フラグ()).get名称());
                koseiIchiran_Row.setShinsakaiIinKaishibi(nullToEmpty(business.get介護認定審査会委員開始日()));
                koseiIchiran_Row.setShinsakaiIinShuryobi(nullToEmpty(business.get介護認定審査会委員終了日()));
                koseiIchiranGridList.add(koseiIchiran_Row);
            }
        }
        div.getDgShinsakaiIinIchiran().setDataSource(ichiranGridList);
        div.getDgShinsakaiIinKoseiIchiran().setDataSource(koseiIchiranGridList);
    }

    /**
     * 介護認定審査会委員一覧全件gridエリア。
     *
     * @param list 一覧全件内容
     */
    public void setAllDataGrid(List<ShinsakaiiinJoho> list) {
        List<dgShinsakaiIinKoseiIchiran_Row> koseiIchiranGridList = div.getDgShinsakaiIinKoseiIchiran().getDataSource();
        List<dgShinsakaiIinIchiran_Row> ichiranGridList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            ShinsakaiiinJoho business = list.get(i);
            for (int j = 0; j < koseiIchiranGridList.size(); j++) {
                if (koseiIchiranGridList.get(j).getShinsakaiIinCode().equals(business.get介護認定審査会委員コード())) {
                    different = false;
                    break;
                }
            }
            if (different) {
                set一覧DataGrid(ichiranGridList, business);
            }
        }
        div.getDgShinsakaiIinIchiran().setDataSource(ichiranGridList);
    }

    /**
     * 介護認定審査会委員一覧で選択されている委員を介護認定審査会委員構成一覧に移動します。
     *
     * @param shinsakaiIinIchiranRow 介護認定審査会委員一覧
     */
    public void set介護認定審査会委員構成一覧(dgShinsakaiIinIchiran_Row shinsakaiIinIchiranRow) {
        dgShinsakaiIinKoseiIchiran_Row row = new dgShinsakaiIinKoseiIchiran_Row();
        row.setShinsakaiIinCode(shinsakaiIinIchiranRow.getShinsakaiIinCode());
        row.setShinsakaiIinName(shinsakaiIinIchiranRow.getShinsakaiIinName());
        row.setShozokuKikan(shinsakaiIinIchiranRow.getShozokuKikan());
        row.setSex(shinsakaiIinIchiranRow.getSex());
        row.setShinsakaiInnShikaku(shinsakaiIinIchiranRow.getShinsakaiIinShikaku());
        row.setGogitaichoKubun(shinsakaiIinIchiranRow.getGogitaichoKubun());
        row.setShukketsuKubun(shinsakaiIinIchiranRow.getShukketsuKubun());
        row.setHaishiFlag(shinsakaiIinIchiranRow.getHaishiFlag());
        row.setShinsakaiIinKaishibi(shinsakaiIinIchiranRow.getShinsakaiIinKaishibi());
        row.setShinsakaiIinShuryobi(shinsakaiIinIchiranRow.getShinsakaiIinShuryobi());
        div.getDgShinsakaiIinKoseiIchiran().getDataSource().add(row);
    }

    /**
     * 介護認定審査会委員構成一覧で選択されている委員を介護認定審査会委員一覧に移動します。
     *
     * @param shinsakaiIinKoseiIchiranRow 介護認定審査会委員構成一覧
     */
    public void set介護認定審査会委員一覧(dgShinsakaiIinKoseiIchiran_Row shinsakaiIinKoseiIchiranRow) {
        dgShinsakaiIinIchiran_Row row = new dgShinsakaiIinIchiran_Row();
        row.setShinsakaiIinCode(shinsakaiIinKoseiIchiranRow.getShinsakaiIinCode());
        row.setShinsakaiIinName(shinsakaiIinKoseiIchiranRow.getShinsakaiIinName());
        row.setShozokuKikan(shinsakaiIinKoseiIchiranRow.getShozokuKikan());
        row.setSex(shinsakaiIinKoseiIchiranRow.getSex());
        row.setShinsakaiIinShikaku(shinsakaiIinKoseiIchiranRow.getShinsakaiInnShikaku());
        row.setHaishiFlag(shinsakaiIinKoseiIchiranRow.getHaishiFlag());
        row.setShinsakaiIinKaishibi(shinsakaiIinKoseiIchiranRow.getShinsakaiIinKaishibi());
        row.setShinsakaiIinShuryobi(shinsakaiIinKoseiIchiranRow.getShinsakaiIinShuryobi());
        row.setGogitaichoKubun(shinsakaiIinKoseiIchiranRow.getGogitaichoKubun());
        row.setShukketsuKubun(shinsakaiIinKoseiIchiranRow.getShukketsuKubun());
        div.getDgShinsakaiIinIchiran().getDataSource().add(row);
    }

    private void set一覧DataGrid(List<dgShinsakaiIinIchiran_Row> ichiranGridList, ShinsakaiiinJoho business) {
        dgShinsakaiIinIchiran_Row ichiran_Row = new dgShinsakaiIinIchiran_Row();
        ichiran_Row.setShinsakaiIinCode(nullToEmpty(business.get介護認定審査会委員コード()));
        ichiran_Row.setShinsakaiIinName(nullToEmpty(business.get介護認定審査会委員氏名()));
        ichiran_Row.setShozokuKikan(nullToEmpty(business.get所属機関()));
        ichiran_Row.setSex(Seibetsu.toValue(nullToEmpty(business.get性別())).get名称());
        ichiran_Row.setShinsakaiIinShikaku(Sikaku.toValue(
                nullToEmpty(business.get介護認定審査会委員資格())).get名称());
        ichiran_Row.setHaishiFlag(IsHaishi.toValue(business.is廃止フラグ()).get名称());
        ichiran_Row.setShinsakaiIinKaishibi(new RDate(nullToEmpty(business.get介護認定審査会委員開始日())
                .toString()).wareki().toDateString());
        ichiran_Row.setShinsakaiIinShuryobi(new RDate(nullToEmpty(business.get介護認定審査会委員終了日())
                .toString()).wareki().toDateString());
        ichiran_Row.setGogitaichoKubun(GogitaichoKubunCode.toValue(
                nullToEmpty(business.get合議体長区分())).get名称());
        ichiran_Row.setShukketsuKubun(IsShusseki.出席.get名称());
        ichiranGridList.add(ichiran_Row);
    }

    private RString nullToEmpty(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return obj;
    }
}
