/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.core.entity.Idokikan;
import jp.co.ndensan.reams.db.dbz.definition.core.entity.SikakuKikan;
import jp.co.ndensan.reams.db.dbz.definition.core.entity.Tasichoson;
import jp.co.ndensan.reams.db.dbz.definition.core.entity.TekiyoJogaisha;
import jp.co.ndensan.reams.db.dbz.definition.core.entity.TokusoRireki;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1002TekiyoJogaishaDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1003TashichosonJushochiTokureiDac;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 資格異動チェック処理
 *
 */
public class SikakuIdoCheckManager {

    private final DbT1001HihokenshaDaichoDac hihokenshaDaiRelateDac;
    private final DbT1002TekiyoJogaishaDac tekiyoJogaishaRelateDac;
    private final DbT1003TashichosonJushochiTokureiDac tashichosonJushochiRelateDac;

    private static final RString DBAE00004 = new RString("DBAE00004");
    private static final RString DBAE00005 = new RString("DBAE00005");

    /**
     * コンストラクタです。
     */
    public SikakuIdoCheckManager() {
        hihokenshaDaiRelateDac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
        tekiyoJogaishaRelateDac = InstanceProvider.create(DbT1002TekiyoJogaishaDac.class);
        tashichosonJushochiRelateDac = InstanceProvider.create(DbT1003TashichosonJushochiTokureiDac.class);
    }

    /**
     * 資格期間の履歴重複チェック処理
     *
     * @param sikakuKikanList 資格期間List
     * @return エラーコード：DBAE00004 メッセージ：被保険者履歴に期間の重複があります。
     */
    public RString sikakuKikanRirekiChofukuCheck(List<SikakuKikan> sikakuKikanList) {
        List<Idokikan> idokikanList = new ArrayList<>();
        if (sikakuKikanList != null && !sikakuKikanList.isEmpty()) {
            for (int i = 0; i < sikakuKikanList.size(); i++) {
                Idokikan idokikan = new Idokikan();
                idokikan.setKaishiYMD(sikakuKikanList.get(i).getKaishiYMD());
                idokikan.setShuryoYMD(sikakuKikanList.get(i).getShuryoYMD());
                idokikan.setEdaNo(sikakuKikanList.get(i).getEdaNo());
                idokikan.setIdoYMD(sikakuKikanList.get(i).getIdoYMD());
                idokikanList.add(idokikan);
            }
            if (!chofukuCheck(idokikanList)) {
                return DBAE00004;
            }
        }
        return RString.EMPTY;
    }

    /**
     * 得喪履歴と他の期間の重複チェック処理
     *
     * @param tokusoRirekiList 得喪履歴List
     * @param 識別コード 識別コード
     * @return エラーコード：DBAE00005 メッセージ：他の期間情報と期間の重複があります。
     */
    public RString tokusouTanoKikanChofukuCheck(List<TokusoRireki> tokusoRirekiList, ShikibetsuCode 識別コード) {
        List<Idokikan> idokikanList = new ArrayList<>();
        List<Idokikan> tekiyoJogaishaList = tekiyoJogaishaRelateDac.selectIdokikanByShikibetsuCode(識別コード);
        List<Idokikan> tashichosonJushochiTokureiList = tashichosonJushochiRelateDac.selectIdokikanByShikibetsuCode(識別コード);

        if (!tekiyoJogaishaList.isEmpty() && !tashichosonJushochiTokureiList.isEmpty()) {
            idokikanList.addAll(checkIdokikanList(tekiyoJogaishaList));
            idokikanList.addAll(checkIdokikanList(tashichosonJushochiTokureiList));

            if (tokusoRirekiList != null && !tokusoRirekiList.isEmpty()) {
                for (TokusoRireki tokusoRireki : tokusoRirekiList) {
                    Idokikan idokikan = new Idokikan();
                    idokikan.setKaishiYMD(tokusoRireki.getKaishiYMD());
                    idokikan.setShuryoYMD(tokusoRireki.getShuryoYMD());
                    idokikan.setIdoYMD(tokusoRireki.getIdoYMD());
                    idokikan.setEdaNo(tokusoRireki.getEdaNo());
                    idokikanList.add(idokikan);
                }
            }
            if (!chofukuCheck(idokikanList)) {
                return DBAE00005;
            }
        }
        return RString.EMPTY;
    }

    /**
     * 適用除外者適用解除履歴と他の期間の重複チェック処理
     *
     * @param tekiyoJogaishaList 適用除外者List
     * @param 識別コード 識別コード
     * @return エラーコード：DBAE00005 メッセージ：他の期間情報と期間の重複があります。
     */
    public RString tekiyoJogaishaChofukuCheck(List<TekiyoJogaisha> tekiyoJogaishaList, ShikibetsuCode 識別コード) {
        List<Idokikan> idokikanList = new ArrayList<>();
        List<Idokikan> hihokenshaDaiList = hihokenshaDaiRelateDac.selectIdokikanByShikibetsuCode(識別コード);
        List<Idokikan> tashichosonJushochiTokureiList = tashichosonJushochiRelateDac.selectIdokikanByShikibetsuCode(識別コード);

        if (!hihokenshaDaiList.isEmpty() && !tashichosonJushochiTokureiList.isEmpty()) {
            idokikanList.addAll(checkIdokikanList(hihokenshaDaiList));
            idokikanList.addAll(checkIdokikanList(tashichosonJushochiTokureiList));

            if (tekiyoJogaishaList != null && !tekiyoJogaishaList.isEmpty()) {
                for (TekiyoJogaisha tekiyoJogaisha : tekiyoJogaishaList) {
                    Idokikan idokikan = new Idokikan();
                    idokikan.setKaishiYMD(tekiyoJogaisha.getKaishiYMD());
                    idokikan.setShuryoYMD(tekiyoJogaisha.getShuryoYMD());
                    idokikan.setEdaNo(tekiyoJogaisha.getEdaNo());
                    idokikan.setIdoYMD(tekiyoJogaisha.getIdoYMD());
                    idokikanList.add(idokikan);
                }
            }
            if (!chofukuCheck(idokikanList)) {
                return DBAE00005;
            }
        }
        return RString.EMPTY;
    }

    /**
     * 他市町村住所地特例適用解除履歴と他の期間の重複チェック処理
     *
     * @param tasichosonList 他市町村List
     * @param 識別コード 識別コード
     * @return エラーコード：DBAE00005 メッセージ：他の期間情報と期間の重複があります。
     */
    public RString tasichosonTokureiChofukuCheck(List<Tasichoson> tasichosonList, ShikibetsuCode 識別コード) {
        List<Idokikan> idokikanList = new ArrayList<>();
        List<Idokikan> hihokenshaDaiList = hihokenshaDaiRelateDac.selectIdokikanByShikibetsuCode(識別コード);
        List<Idokikan> tekiyoJogaishaList = tekiyoJogaishaRelateDac.selectIdokikanByShikibetsuCode(識別コード);

        if (!hihokenshaDaiList.isEmpty() && !tekiyoJogaishaList.isEmpty()) {
            idokikanList.addAll(checkIdokikanList(hihokenshaDaiList));
            idokikanList.addAll(checkIdokikanList(tekiyoJogaishaList));

            if (tasichosonList != null && !tasichosonList.isEmpty()) {
                for (Tasichoson tasichoson : tasichosonList) {
                    Idokikan idokikan = new Idokikan();
                    idokikan.setKaishiYMD(tasichoson.getKaishiYMD());
                    idokikan.setShuryoYMD(tasichoson.getShuryoYMD());
                    idokikan.setIdoYMD(tasichoson.getIdoYMD());
                    idokikan.setEdaNo(tasichoson.getEdaNo());
                    idokikanList.add(idokikan);
                }
            }
            if (!chofukuCheck(idokikanList)) {
                return DBAE00005;
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

}
