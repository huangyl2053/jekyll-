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
import jp.co.ndensan.reams.db.dbe.definition.core.hoshu.GogitaichoKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.IsGogitaiSeishinkaSonzai;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.IsShusseki;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5140002.ShinsakaiIinWaritsukeDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5140002.dgShinsakaiIinIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5140002.dgShinsakaiIinKoseiIchiran_Row;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.shinsakai.IsGogitaiDummy;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.IsHaishi;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.Sikaku;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;

/**
 * 介護認定審査会割当委員情報のHandlerクラスです。
 *
 * @reamsid_L DBE-0130-020 xuyannan
 */
public class ShinsakaiIinWaritsukeHandler {

    private static final RString 介護認定審査会の前 = new RString("第");
    private static final RString 介護認定審査会の後 = new RString("回審査会");
    private static final RString SELECTEDKEY = new RString("key0");
    private static final RString 通常 = new RString("0");
    private static final RString 廃止フラグ_登録可 = new RString("登録可");
    private static final RString 廃止フラグ_不可 = new RString("不可");
    private boolean different;
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
     * @param 開催番号 開催番号
     */
    public void onLoad(List<ShinsakaiKaisaiYoteiJoho> saiYoteiJoho, RString 開催番号) {
        List<RString> chkDummyKubunlist = new ArrayList<>();
        List<RString> chkSeishinkailist = new ArrayList<>();
        ShinsakaiKaisaiYoteiJoho business = saiYoteiJoho.get(0);
        RStringBuilder builder = new RStringBuilder();
        builder.append(介護認定審査会の前);
        builder.append(開催番号);
        builder.append(介護認定審査会の後);
        div.getTxtKaigoNinteiShinsakai().setValue(builder.toRString());
        div.getTxtGogitai().setValue(nullToEmpty(business.get合議体()));
        div.getTxtKaishiYoteiTime().setValue(new RTime(nullToEmpty(business.get開始予定時間())));
        if (IsGogitaiDummy.toValue(business.isダミー区分()).is合議体ダミーフラグTrue()) {
            chkDummyKubunlist.add(SELECTEDKEY);
        }
        div.getChkDummyKubun().setSelectedItemsByKey(chkDummyKubunlist);
        div.getTxtKaisaiYoteibi().setValue(RString.isNullOrEmpty(business.get開催予定日()) ? null
                : new RDate(business.get開催予定日().toString()));
        div.getTxtKaisaiBasho().setValue(nullToEmpty(business.get開催場所()));
        div.getTxtShuryoYoteiTime().setValue(RString.isNullOrEmpty(business.get終了予定時間()) ? null
                : new RTime(business.get終了予定時間()));
        div.getTxtYoteiTeiin().setValue(new RString(String.valueOf(business.get予定定員())));
        if (IsGogitaiSeishinkaSonzai.toValue(business.is精神科医()).is合議体精神科医存在()) {
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
                koseiIchiran_Row.setGogitaichoKubun(通常.equals(nullToEmpty(business.get合議体長区分())) ? RString.EMPTY
                        : GogitaichoKubunCode.toValue(nullToEmpty(business.get合議体長区分())).get名称());
                koseiIchiran_Row.setShukketsuKubun(IsShusseki.出席.get名称());
                koseiIchiran_Row.setHaishiFlag(IsHaishi.廃止.equals(IsHaishi.toValue(business.is廃止フラグ()))
                        ? 廃止フラグ_不可 : 廃止フラグ_登録可);
                koseiIchiran_Row.setShinsakaiIinKaishibi(kaishiYMDtoEmpty(business.get介護認定審査会委員開始日()).isEmpty() ? null
                        : new RDate(business.get介護認定審査会委員開始日()
                                .toString()).wareki().toDateString());
                koseiIchiran_Row.setShinsakaiIinShuryobi(shuryoYMDtoEmpty(business.get介護認定審査会委員終了日()).isEmpty() ? null
                        : new RDate(business.get介護認定審査会委員終了日()
                                .toString()).wareki().toDateString());
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
            different = true;
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

    /**
     * 排他制御を行います。
     */
    public void 前排他制御処理() {
        LockingKey lockingKey = new LockingKey(new RString("ShinsakaiNo"));
        if (!RealInitialLocker.tryGetLock(lockingKey)) {
            div.setReadOnly(true);
            throw new ApplicationException(UrErrorMessages.排他_他のユーザが使用中.getMessage());
        }
    }

    /**
     * 排他制御の解除を行います。
     */
    public void 前排他解除処理() {
        LockingKey lockingKey = new LockingKey(new RString("ShinsakaiNo"));
        RealInitialLocker.release(lockingKey);
    }

    private void set一覧DataGrid(List<dgShinsakaiIinIchiran_Row> ichiranGridList, ShinsakaiiinJoho business) {
        dgShinsakaiIinIchiran_Row ichiran_Row = new dgShinsakaiIinIchiran_Row();
        ichiran_Row.setShinsakaiIinCode(nullToEmpty(business.get介護認定審査会委員コード()));
        ichiran_Row.setShinsakaiIinName(nullToEmpty(business.get介護認定審査会委員氏名()));
        ichiran_Row.setShozokuKikan(nullToEmpty(business.get所属機関()));
        ichiran_Row.setSex(Seibetsu.toValue(nullToEmpty(business.get性別())).get名称());
        ichiran_Row.setShinsakaiIinShikaku(Sikaku.toValue(
                nullToEmpty(business.get介護認定審査会委員資格())).get名称());
        ichiran_Row.setHaishiFlag(IsHaishi.廃止.equals(IsHaishi.toValue(business.is廃止フラグ()))
                ? 廃止フラグ_不可 : 廃止フラグ_登録可);
        ichiran_Row.setShinsakaiIinKaishibi(kaishiYMDtoEmpty(business.get介護認定審査会委員開始日()).isEmpty() ? RString.EMPTY
                : new RDate(business.get介護認定審査会委員開始日()
                        .toString()).wareki().toDateString());
        ichiran_Row.setShinsakaiIinShuryobi(shuryoYMDtoEmpty(business.get介護認定審査会委員終了日()).isEmpty() ? RString.EMPTY
                : new RDate(business.get介護認定審査会委員終了日()
                        .toString()).wareki().toDateString());
        ichiran_Row.setGogitaichoKubun(通常.equals(nullToEmpty(business.get合議体長区分())) ? RString.EMPTY
                : GogitaichoKubunCode.toValue(nullToEmpty(business.get合議体長区分())).get名称());
        ichiran_Row.setShukketsuKubun(IsShusseki.出席.get名称());
        ichiranGridList.add(ichiran_Row);
    }

    private RString kaishiYMDtoEmpty(RString obj) {
        final RString kaishiYMD = new RString("00000000");
        if (RString.isNullOrEmpty(obj) || obj.equals(kaishiYMD)) {
            return RString.EMPTY;
        } else {
            return obj;
        }
    }

    private RString shuryoYMDtoEmpty(RString obj) {
        final RString shuryoYMD = new RString("99999999");
        if (RString.isNullOrEmpty(obj) || obj.equals(shuryoYMD)) {
            return RString.EMPTY;
        } else {
            return obj;
        }
    }

    private RString nullToEmpty(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return obj;
    }
}
