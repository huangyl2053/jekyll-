/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.sikakuidocheck;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.core.sikakuidocheck.Idokikan;
import jp.co.ndensan.reams.db.dbz.definition.core.sikakuidocheck.SikakuKikan;
import jp.co.ndensan.reams.db.dbz.definition.core.sikakuidocheck.Tashichoson;
import jp.co.ndensan.reams.db.dbz.definition.core.sikakuidocheck.TekiyoJogaisha;
import jp.co.ndensan.reams.db.dbz.definition.core.sikakuidocheck.TokusoRireki;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1002TekiyoJogaishaDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1003TashichosonJushochiTokureiDac;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 資格異動チェック処理クラスです。
 *
 */
public class SikakuIdoCheckManager {

    //QA166 張紅麗　エラーコードの確認 QA回答まち
    private static final RString ERR_CODE_DBAE00004 = new RString("DBAE00004");
    private static final RString ERR_CODE_DBAE00005 = new RString("DBAE00005");
    private final DbT1001HihokenshaDaichoDac hihokenshaDaiRelateDac;
    private final DbT1002TekiyoJogaishaDac tekiyoJogaishaRelateDac;
    private final DbT1003TashichosonJushochiTokureiDac tashichosonJushochiRelateDac;

    /**
     * コンストラクタです。
     */
    SikakuIdoCheckManager() {
        hihokenshaDaiRelateDac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
        tekiyoJogaishaRelateDac = InstanceProvider.create(DbT1002TekiyoJogaishaDac.class);
        tashichosonJushochiRelateDac = InstanceProvider.create(DbT1003TashichosonJushochiTokureiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param DbT1001HihokenshaDaichoDac hihokenshaDaiRelateDac
     * @param DbT1002TekiyoJogaishaDac tekiyoJogaishaRelateDac
     * @@param DbT1003TashichosonJushochiTokureiDac tashichosonJushochiRelateDac
     */
    SikakuIdoCheckManager(DbT1001HihokenshaDaichoDac hihDac, DbT1002TekiyoJogaishaDac tekDac, DbT1003TashichosonJushochiTokureiDac tasDac) {
        this.hihokenshaDaiRelateDac = hihDac;
        this.tekiyoJogaishaRelateDac = tekDac;
        this.tashichosonJushochiRelateDac = tasDac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SikakuIdoCheckManager}のインスタンスを返します。
     *
     * @return SikakuIdoCheckManager
     *
     */
    public static SikakuIdoCheckManager createInstance() {
        return InstanceProvider.create(SikakuIdoCheckManager.class);
    }

    /**
     * 資格期間の履歴重複チェック処理です。
     *
     * @param sikakuKikanList List<SikakuKikan>
     * @return RString
     */
    public RString sikakuKikanRirekiChofukuCheck(List<SikakuKikan> sikakuKikanList) {
        List<Idokikan> idokikanList = new ArrayList<>();
        if (sikakuKikanList != null && !sikakuKikanList.isEmpty()) {
            for (SikakuKikan sikakuKikan : sikakuKikanList) {
                Idokikan idokikan = new Idokikan();
                idokikan.setKaishiYMD(sikakuKikan.getKaishiYMD());
                idokikan.setShuryoYMD(sikakuKikan.getShuryoYMD());
                idokikanList.add(idokikan);
            }
            if (!chofukuCheck(idokikanList)) {
                return ERR_CODE_DBAE00004;
            }
        }
        return RString.EMPTY;
    }

    /**
     * 得喪履歴と他の期間の重複チェック処理です。
     *
     * @param tokusoRirekiList List<TokusoRireki>
     * @param 識別コード ShikibetsuCode
     * @return RString
     */
    public RString tokusouTanoKikanChofukuCheck(List<TokusoRireki> tokusoRirekiList, ShikibetsuCode 識別コード) {
        List<Idokikan> idokikanList = new ArrayList<>();
        List<DbT1002TekiyoJogaishaEntity> dbt1002List = tekiyoJogaishaRelateDac.selectIdokikanByShikibetsuCode(識別コード);
        List<Idokikan> tekiyoJogaishaList = getTekiyoJogaishaList(dbt1002List);
        List<DbT1003TashichosonJushochiTokureiEntity> dbt1003List = tashichosonJushochiRelateDac.selectIdokikanByShikibetsuCode(識別コード);
        List<Idokikan> tashichosonJushochiTokureiList = getTashichosonList(dbt1003List);
        if (!tekiyoJogaishaList.isEmpty() && !tashichosonJushochiTokureiList.isEmpty()) {
            idokikanList.addAll(checkIdokikanList(tekiyoJogaishaList));
            idokikanList.addAll(checkIdokikanList(tashichosonJushochiTokureiList));
            if (idokikanList.isEmpty()) {
                return RString.EMPTY;
            }
            if (tokusoRirekiList != null && !tokusoRirekiList.isEmpty()) {
                for (TokusoRireki tokusoRireki : tokusoRirekiList) {
                    Idokikan idokikan = new Idokikan();
                    idokikan.setKaishiYMD(tokusoRireki.getKaishiYMD());
                    idokikan.setShuryoYMD(tokusoRireki.getShuryoYMD());
                    idokikanList.add(idokikan);
                }
            }
            if (!chofukuCheck(idokikanList)) {
                return ERR_CODE_DBAE00005;
            }
        }
        return RString.EMPTY;
    }

    /**
     * 適用除外者適用解除履歴と他の期間の重複チェック処理です。
     *
     * @param tekiyoJogaishaList List<TekiyoJogaisha>
     * @param 識別コード ShikibetsuCode
     * @return RString
     */
    public RString tekiyoJogaishaChofukuCheck(List<TekiyoJogaisha> tekiyoJogaishaList, ShikibetsuCode 識別コード) {
        List<Idokikan> idokikanList = new ArrayList<>();
        List<DbT1001HihokenshaDaichoEntity> dbt1001List = hihokenshaDaiRelateDac.selectIdokikanByShikibetsuCode(識別コード);
        List<Idokikan> hihokenshaDaiList = getHihokenshaList(dbt1001List);
        List<DbT1003TashichosonJushochiTokureiEntity> dbt1003List = tashichosonJushochiRelateDac.selectIdokikanByShikibetsuCode(識別コード);
        List<Idokikan> tashichosonJushochiTokureiList = getTashichosonList(dbt1003List);
        if (!hihokenshaDaiList.isEmpty() && !tashichosonJushochiTokureiList.isEmpty()) {
            idokikanList.addAll(checkIdokikanList(hihokenshaDaiList));
            idokikanList.addAll(checkIdokikanList(tashichosonJushochiTokureiList));
            if (idokikanList.isEmpty()) {
                return RString.EMPTY;
            }
            if (tekiyoJogaishaList != null && !tekiyoJogaishaList.isEmpty()) {
                for (TekiyoJogaisha tekiyoJogaisha : tekiyoJogaishaList) {
                    Idokikan idokikan = new Idokikan();
                    idokikan.setKaishiYMD(tekiyoJogaisha.getKaishiYMD());
                    idokikan.setShuryoYMD(tekiyoJogaisha.getShuryoYMD());
                    idokikanList.add(idokikan);
                }
            }
            if (!chofukuCheck(idokikanList)) {
                return ERR_CODE_DBAE00005;
            }
        }
        return RString.EMPTY;
    }

    /**
     * 他市町村住所地特例適用解除履歴と他の期間の重複チェック処理です。
     *
     * @param tasichosonList List<Tasichoson>
     * @param 識別コード ShikibetsuCode
     * @return RString
     */
    public RString tasichosonTokureiChofukuCheck(List<Tashichoson> tasichosonList, ShikibetsuCode 識別コード) {
        List<Idokikan> idokikanList = new ArrayList<>();
        List<DbT1001HihokenshaDaichoEntity> dbt1001List = hihokenshaDaiRelateDac.selectIdokikanByShikibetsuCode(識別コード);
        List<Idokikan> hihokenshaDaiList = getHihokenshaList(dbt1001List);
        List<DbT1002TekiyoJogaishaEntity> dbt1002List = tekiyoJogaishaRelateDac.selectIdokikanByShikibetsuCode(識別コード);
        List<Idokikan> tekiyoJogaishaList = getTekiyoJogaishaList(dbt1002List);

        if (!hihokenshaDaiList.isEmpty() && !tekiyoJogaishaList.isEmpty()) {
            idokikanList.addAll(checkIdokikanList(hihokenshaDaiList));
            idokikanList.addAll(checkIdokikanList(tekiyoJogaishaList));
            if (idokikanList.isEmpty()) {
                return RString.EMPTY;
            }
            if (tasichosonList != null && !tasichosonList.isEmpty()) {
                for (Tashichoson tasichoson : tasichosonList) {
                    Idokikan idokikan = new Idokikan();
                    idokikan.setKaishiYMD(tasichoson.getKaishiYMD());
                    idokikan.setShuryoYMD(tasichoson.getShuryoYMD());
                    idokikanList.add(idokikan);
                }
            }
            if (!chofukuCheck(idokikanList)) {
                return ERR_CODE_DBAE00005;
            }
        }
        return RString.EMPTY;
    }

    private boolean chofukuCheck(List<Idokikan> idokikanList) {
        boolean checkFlag = true;
        for (int i = 0; i < idokikanList.size(); i++) {
            for (int j = i + 1; j < idokikanList.size(); j++) {
                Idokikan idokikan1 = idokikanList.get(i);
                Idokikan idokikan2 = idokikanList.get(j);
                if (idokikan1.getKaishiYMD().isBeforeOrEquals(idokikan2.getKaishiYMD())) {
                    Idokikan temp = new Idokikan();
                    temp.setKaishiYMD(idokikanList.get(j).getKaishiYMD());
                    temp.setShuryoYMD(idokikanList.get(j).getShuryoYMD());
                    temp.setEdaNo(idokikanList.get(j).getEdaNo());
                    temp.setIdoYMD(idokikanList.get(j).getIdoYMD());
                    idokikanList.set(j, idokikanList.get(i));
                    idokikanList.set(i, temp);
                }
            }
        }
        for (int k = 0; k < idokikanList.size() - 1; k++) {
            if (idokikanList.get(k).getKaishiYMD().isBefore(idokikanList.get(k + 1).getShuryoYMD())) {
                checkFlag = false;
                return checkFlag;
            }
        }
        return checkFlag;
    }

    private List<Idokikan> checkIdokikanList(List<Idokikan> idokikanList) {
        for (int i = 0; i < idokikanList.size(); i++) {
            for (int j = i + 1; j < idokikanList.size(); j++) {
                Idokikan idokikan1 = idokikanList.get(i);
                Idokikan idokikan2 = idokikanList.get(j);
                if (idokikan1.getKaishiYMD().equals(idokikan2.getKaishiYMD())) {
                    if (idokikan1.getIdoYMD().equals(idokikan2.getIdoYMD())) {
                        idokikanList = remove1(idokikanList, idokikan1, idokikan2);
                    } else {
                        idokikanList = remove2(idokikanList, idokikan1, idokikan2);
                    }
                }
            }
        }
        return idokikanList;
    }

    private List<Idokikan> remove1(List<Idokikan> idokikanList, Idokikan idokikan1, Idokikan idokikan2) {
        if (idokikan1.getEdaNo().compareTo(idokikan2.getEdaNo()) > 0) {
            idokikanList.remove(idokikan2);
        } else {
            idokikanList.remove(idokikan1);
        }
        return idokikanList;
    }

    private List<Idokikan> remove2(List<Idokikan> idokikanList, Idokikan idokikan1, Idokikan idokikan2) {
        if (idokikan2.getIdoYMD().isBefore(idokikan1.getIdoYMD())) {
            idokikanList.remove(idokikan2);
        } else {
            idokikanList.remove(idokikan1);
        }
        return idokikanList;
    }

    private List<Idokikan> getTekiyoJogaishaList(List<DbT1002TekiyoJogaishaEntity> tekiyoJogaishaEntityList) {
        List<Idokikan> idokikanList = new ArrayList<>();
        for (DbT1002TekiyoJogaishaEntity tekiyoJogaisha : tekiyoJogaishaEntityList) {
            Idokikan idokikan = new Idokikan();
            idokikan.setKaishiYMD(tekiyoJogaisha.getTekiyoYMD());
            idokikan.setShuryoYMD(tekiyoJogaisha.getKaijoYMD());
            idokikan.setEdaNo(tekiyoJogaisha.getEdaNo());
            idokikan.setIdoYMD(tekiyoJogaisha.getIdoYMD());
            idokikanList.add(idokikan);
        }
        return idokikanList;
    }

    private List<Idokikan> getTashichosonList(List<DbT1003TashichosonJushochiTokureiEntity> tashichosonEntityList) {
        List<Idokikan> idokikanList = new ArrayList<>();
        for (DbT1003TashichosonJushochiTokureiEntity tashichosonJushochiTokurei : tashichosonEntityList) {
            Idokikan idokikan = new Idokikan();
            idokikan.setKaishiYMD(tashichosonJushochiTokurei.getTekiyoYMD());
            idokikan.setShuryoYMD(tashichosonJushochiTokurei.getKaijoYMD());
            idokikan.setIdoYMD(tashichosonJushochiTokurei.getIdoYMD());
            idokikan.setEdaNo(tashichosonJushochiTokurei.getEdaNo());
            idokikanList.add(idokikan);
        }
        return idokikanList;
    }

    private List<Idokikan> getHihokenshaList(List<DbT1001HihokenshaDaichoEntity> hihokenshaDaiList) {
        List<Idokikan> idokikanList = new ArrayList<>();
        for (DbT1001HihokenshaDaichoEntity hihokenshaDai : hihokenshaDaiList) {
            Idokikan idokikan = new Idokikan();
            idokikan.setKaishiYMD(hihokenshaDai.getShikakuShutokuYMD());
            idokikan.setShuryoYMD(hihokenshaDai.getShikakuSoshitsuYMD());
            idokikan.setIdoYMD(hihokenshaDai.getIdoYMD());
            idokikan.setEdaNo(hihokenshaDai.getEdaNo());
            idokikanList.add(idokikan);
        }
        return idokikanList;
    }
}
