/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5140002;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinwaritsuke.ShinsakaiIinKoseIchiran;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinwaritsuke.ShinsakaiKaisaiYoteiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinwaritsuke.ShinsakaiiinJoho;
import jp.co.ndensan.reams.db.dbe.definition.core.hoshu.GogitaichoKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.IsGogitaiSeishinkaSonzai;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.IsShusseki;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.KaigoninteiShinsakaiGichoKubunCode;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5140002.ShinsakaiIinWaritsukeDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5140002.dgShinsakaiIinIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5140002.dgShinsakaiIinKoseiIchiran_Row;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.shinsakai.IsGogitaiDummy;
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
        div.getWaritsuke().getTxtKaigoNinteiShinsakai().setValue(builder.toRString());
        div.getWaritsuke().getTxtGogitai().setValue(nullToEmpty(business.get合議体()));
        div.getWaritsuke().getTxtKaishiYoteiTime().setValue(new RTime(nullToEmpty(business.get開始予定時間())));
        if (IsGogitaiDummy.toValue(business.isダミー区分()).is合議体ダミーフラグTrue()) {
            chkDummyKubunlist.add(SELECTEDKEY);
        }
        div.getWaritsuke().getChkDummyKubun().setSelectedItemsByKey(chkDummyKubunlist);
        div.getWaritsuke().getTxtKaisaiYoteibi().setValue(RString.isNullOrEmpty(business.get開催予定日()) ? null
                : new RDate(business.get開催予定日().toString()));
        div.getWaritsuke().getTxtKaisaiBasho().setValue(nullToEmpty(business.get開催場所()));
        div.getWaritsuke().getTxtShuryoYoteiTime().setValue(RString.isNullOrEmpty(business.get終了予定時間()) ? null
                : new RTime(business.get終了予定時間()));
        div.getWaritsuke().getTxtYoteiTeiin().setValue(new RString(String.valueOf(business.get予定定員())));
        if (IsGogitaiSeishinkaSonzai.toValue(business.is精神科医()).is合議体精神科医存在()) {
            chkSeishinkailist.add(SELECTEDKEY);
        }
        div.getWaritsuke().getChkSeishinkai().setSelectedItemsByKey(chkSeishinkailist);
        div.getWaritsuke().getTxtKijunYMD().setValue(RDate.getNowDate());
    }

    /**
     * 介護認定審査会委員(構成)一覧gridエリア。
     *
     * @param iinKoseList 審査会委員構成一覧リスト
     * @param iinJoholist 審査会委員一覧リスト
     */
    public void setShinsakaiIinDataGrid(List<ShinsakaiIinKoseIchiran> iinKoseList,
            List<ShinsakaiiinJoho> iinJoholist) {
        List<dgShinsakaiIinKoseiIchiran_Row> koseiIins = toDgShinsakaiIinKoseiIchiran_Rows(iinKoseList);
        div.getWaritsuke().getDgShinsakaiIinKoseiIchiran().setDataSource(
                koseiIins
        );
        div.getWaritsuke().getDgShinsakaiIinIchiran().setDataSource(
                toDgShinsakaiIinIchiran_Rows(iinJoholist, koseiIins)
        );
    }

    private static List<dgShinsakaiIinKoseiIchiran_Row> toDgShinsakaiIinKoseiIchiran_Rows(List<ShinsakaiIinKoseIchiran> koseiIins) {
        List<dgShinsakaiIinKoseiIchiran_Row> list = new ArrayList<>();
        for (ShinsakaiIinKoseIchiran item : koseiIins) {
            list.add(toDgShinsakaiIinKoseiIchiran_Row(item));
        }
        return list;
    }

    private static dgShinsakaiIinKoseiIchiran_Row toDgShinsakaiIinKoseiIchiran_Row(ShinsakaiIinKoseIchiran shinsakaiIinJoho) {
        dgShinsakaiIinKoseiIchiran_Row row = new dgShinsakaiIinKoseiIchiran_Row();
        row.setShinsakaiIinCode(nullToEmpty(shinsakaiIinJoho.get介護認定審査会委員コード()));
        row.setShinsakaiIinName(nullToEmpty(shinsakaiIinJoho.get介護認定審査会委員氏名()));
        row.setShozokuKikan(nullToEmpty(shinsakaiIinJoho.get所属機関()));
        row.setSex(Seibetsu.toValue(nullToEmpty(shinsakaiIinJoho.get性別())).get名称());
        row.setShinsakaiInnShikaku(Sikaku.toValue(
                nullToEmpty(shinsakaiIinJoho.get介護認定審査会委員資格())).get名称());
        row.setGogitaichoKubun(!RString.isNullOrEmpty(shinsakaiIinJoho.get合議体長区分())
                ? get議長区分名称(shinsakaiIinJoho.get合議体長区分()) : RString.EMPTY
        );
        row.setShukketsuKubun(shinsakaiIinJoho.get出欠区分() ? IsShusseki.出席.get名称() : IsShusseki.欠席.get名称());
        row.setShinsakaiIinKaishibi(kaishiYMDtoEmpty(shinsakaiIinJoho.get介護認定審査会委員開始日()).isEmpty() ? null
                : new RDate(shinsakaiIinJoho.get介護認定審査会委員開始日()
                        .toString()).wareki().toDateString());
        row.setShinsakaiIinShuryobi(shuryoYMDtoEmpty(shinsakaiIinJoho.get介護認定審査会委員終了日()).isEmpty() ? null
                : new RDate(shinsakaiIinJoho.get介護認定審査会委員終了日()
                        .toString()).wareki().toDateString());
        return row;
    }

    private static List<dgShinsakaiIinIchiran_Row> toDgShinsakaiIinIchiran_Rows(List<ShinsakaiiinJoho> shinsakaiIins,
            List<dgShinsakaiIinKoseiIchiran_Row> koseiIins) {
        Set<RString> koseiIinCodeSet = toKoseiIinIinCodeSet(koseiIins);
        List<dgShinsakaiIinIchiran_Row> list = new ArrayList<>();
        for (ShinsakaiiinJoho item : shinsakaiIins) {
            if (koseiIinCodeSet.contains(item.get介護認定審査会委員コード())) {
                continue;
            }
            list.add(toDgShinsakaiIinIchiran_Row(item));
        }
        return list;
    }

    private static Set<RString> toKoseiIinIinCodeSet(List<dgShinsakaiIinKoseiIchiran_Row> koseiIins) {
        Set<RString> set = new HashSet<>();
        for (dgShinsakaiIinKoseiIchiran_Row row : koseiIins) {
            set.add(row.getShinsakaiIinCode());
        }
        return set;
    }

    private static dgShinsakaiIinIchiran_Row toDgShinsakaiIinIchiran_Row(ShinsakaiiinJoho business) {
        dgShinsakaiIinIchiran_Row ichiran_Row = new dgShinsakaiIinIchiran_Row();
        ichiran_Row.setShinsakaiIinCode(nullToEmpty(business.get介護認定審査会委員コード()));
        ichiran_Row.setShinsakaiIinName(nullToEmpty(business.get介護認定審査会委員氏名()));
        ichiran_Row.setShozokuKikan(nullToEmpty(business.get所属機関()));
        ichiran_Row.setSex(Seibetsu.toValue(nullToEmpty(business.get性別())).get名称());
        ichiran_Row.setShinsakaiIinShikaku(Sikaku.toValue(
                nullToEmpty(business.get介護認定審査会委員資格())).get名称());
        ichiran_Row.setShinsakaiIinKaishibi(kaishiYMDtoEmpty(business.get介護認定審査会委員開始日()).isEmpty() ? RString.EMPTY
                : new RDate(business.get介護認定審査会委員開始日()
                        .toString()).wareki().toDateString());
        ichiran_Row.setShinsakaiIinShuryobi(shuryoYMDtoEmpty(business.get介護認定審査会委員終了日()).isEmpty() ? RString.EMPTY
                : new RDate(business.get介護認定審査会委員終了日()
                        .toString()).wareki().toDateString());
        ichiran_Row.setGogitaichoKubun(通常.equals(nullToEmpty(business.get合議体長区分())) ? RString.EMPTY
                : GogitaichoKubunCode.toValue(nullToEmpty(business.get合議体長区分())).get名称());
        ichiran_Row.setShukketsuKubun(IsShusseki.出席.get名称());
        return ichiran_Row;
    }

    /**
     * 介護認定審査会委員一覧全件gridエリア。
     *
     * @param list 一覧全件内容
     */
    public void setGridToDataRemovingCurrentKoseiIins(List<ShinsakaiiinJoho> list) {
        div.getWaritsuke().getDgShinsakaiIinIchiran().setDataSource(
                toDgShinsakaiIinIchiran_Rows(list, div.getWaritsuke().getDgShinsakaiIinKoseiIchiran().getDataSource())
        );
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
        row.setGogitaichoKubun(get議長区分名称変換(shinsakaiIinIchiranRow.getGogitaichoKubun()));
        row.setShukketsuKubun(shinsakaiIinIchiranRow.getShukketsuKubun());
        row.setShinsakaiIinKaishibi(shinsakaiIinIchiranRow.getShinsakaiIinKaishibi());
        row.setShinsakaiIinShuryobi(shinsakaiIinIchiranRow.getShinsakaiIinShuryobi());
        div.getWaritsuke().getDgShinsakaiIinKoseiIchiran().getDataSource().add(row);
    }

    private RString get議長区分名称変換(RString 合議体長区分) {
        RString 議長区分名称 = KaigoninteiShinsakaiGichoKubunCode.委員.get名称();
        if (GogitaichoKubunCode.合議体長.get名称().equals(合議体長区分)) {
            議長区分名称 = KaigoninteiShinsakaiGichoKubunCode.議長.get名称();
        }
        return 議長区分名称;
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
        row.setShinsakaiIinKaishibi(kaishiYMDtoEmpty(shinsakaiIinKoseiIchiranRow.getShinsakaiIinKaishibi()).isEmpty() ? RString.EMPTY
                : new RDate(shinsakaiIinKoseiIchiranRow.getShinsakaiIinKaishibi()
                        .toString()).wareki().toDateString());
        row.setShinsakaiIinShuryobi(shuryoYMDtoEmpty(shinsakaiIinKoseiIchiranRow.getShinsakaiIinShuryobi()).isEmpty() ? RString.EMPTY
                : new RDate(shinsakaiIinKoseiIchiranRow.getShinsakaiIinShuryobi()
                        .toString()).wareki().toDateString());
        row.setGogitaichoKubun(shinsakaiIinKoseiIchiranRow.getGogitaichoKubun());
        row.setShukketsuKubun(shinsakaiIinKoseiIchiranRow.getShukketsuKubun());
        div.getWaritsuke().getDgShinsakaiIinIchiran().getDataSource().add(row);
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

    private static RString get議長区分名称(RString 区分コード) {
        RString 議長区分名称 = RString.EMPTY;
        for (KaigoninteiShinsakaiGichoKubunCode item : KaigoninteiShinsakaiGichoKubunCode.values()) {
            if (item.getコード().equals(区分コード)) {
                議長区分名称 = item.get名称();
            }
        }
        return 議長区分名称;
    }

    private static RString kaishiYMDtoEmpty(RString obj) {
        final RString kaishiYMD = new RString("00000000");
        if (RString.isNullOrEmpty(obj) || obj.equals(kaishiYMD)) {
            return RString.EMPTY;
        } else {
            return obj;
        }
    }

    private static RString shuryoYMDtoEmpty(RString obj) {
        final RString shuryoYMD = new RString("99999999");
        if (RString.isNullOrEmpty(obj) || obj.equals(shuryoYMD)) {
            return RString.EMPTY;
        } else {
            return obj;
        }
    }

    private static RString nullToEmpty(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return obj;
    }
}
