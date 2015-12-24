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
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic.sikakuidocheck.ISikakuIdoCheckMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 資格異動チェック処理クラスです。
 *
 */
public class SikakuIdoCheckManager {

    private static final RString ERR_CODE_DBAE00007 = new RString("DBAE00007");
    private static final RString ERR_CODE_DBAE00008 = new RString("DBAE00008");
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    SikakuIdoCheckManager() {
        mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param DbT1001HihokenshaDaichoDac hihokenshaDaiRelateDac
     * @param DbT1002TekiyoJogaishaDac tekiyoJogaishaRelateDac
     * @@param DbT1003TashichosonJushochiTokureiDac tashichosonJushochiRelateDac
     */
    SikakuIdoCheckManager(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
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
     * @param sikakuKikanList sikakuKikanList
     * @return RString
     */
    public RString sikakuKikanRirekiChofukuCheck(List<SikakuKikan> sikakuKikanList) {
        if (sikakuKikanList != null && !sikakuKikanList.isEmpty()) {
            List<Idokikan> idokikanList = new ArrayList<>();
            for (SikakuKikan sikakuKikan : sikakuKikanList) {
                Idokikan idokikan = new Idokikan();
                idokikan.setKaishiYMD(sikakuKikan.getKaishiYMD());
                idokikan.setShuryoYMD(sikakuKikan.getShuryoYMD());
                idokikanList.add(idokikan);
            }
            if (!chofukuCheck(idokikanList)) {
                return ERR_CODE_DBAE00007;
            }
        }
        return RString.EMPTY;
    }

    /**
     * 得喪履歴と他の期間の重複チェック処理です。
     *
     * @param tokusoRireki List<TokusoRireki>
     * @param 識別コード 識別コード
     * @return RString
     */
    public RString tokusouTanoKikanChofukuCheck(List<TokusoRireki> tokusoRireki, ShikibetsuCode 識別コード) {

        Idokikan 資格取得年月日情報他市町村住所地特例 = get資格取得年月日情報By他市町村住所地特例(識別コード);
        Idokikan 資格取得年月日情報適用除外者 = get資格取得年月日情報By適用除外者(識別コード);

        if (資格取得年月日情報適用除外者 != null
                && 資格取得年月日情報他市町村住所地特例 != null) {
            List<Idokikan> idokikanList = new ArrayList<>();
            idokikanList.add(資格取得年月日情報他市町村住所地特例);
            idokikanList.add(資格取得年月日情報適用除外者);
            idokikanList.addAll(get資格取得年月日情報By引数TokusoRireki(tokusoRireki));
            if (!chofukuCheck(idokikanList)) {
                return ERR_CODE_DBAE00008;
            }
        }
        return RString.EMPTY;
    }

    /**
     * 適用除外者適用解除履歴と他の期間の重複チェック処理です。
     *
     * @param tekiyoJogaisha List<TekiyoJogaisha>
     * @param 識別コード 識別コード
     * @return RString
     */
    public RString tekiyoJogaishaChofukuCheck(List<TekiyoJogaisha> tekiyoJogaisha, ShikibetsuCode 識別コード) {

        List<Idokikan> 資格取得年月日情報被保険者台帳 = get資格取得年月日情報By被保険者台帳(識別コード);
        Idokikan 資格取得年月日情報他市町村住所地特例 = get資格取得年月日情報By他市町村住所地特例(識別コード);
        if (!資格取得年月日情報被保険者台帳.isEmpty()
                && 資格取得年月日情報他市町村住所地特例 != null) {
            List<Idokikan> idokikanList = new ArrayList<>();
            idokikanList.addAll(資格取得年月日情報被保険者台帳);
            idokikanList.add(資格取得年月日情報他市町村住所地特例);
            idokikanList.addAll(get資格取得年月日情報By引数TekiyoJogaisha(tekiyoJogaisha));
            if (!chofukuCheck(idokikanList)) {
                return ERR_CODE_DBAE00008;
            }
        }
        return RString.EMPTY;
    }

    /**
     * 他市町村住所地特例適用解除履歴と他の期間の重複チェック処理です。
     *
     * @param tashichoson List<Tashichoson>
     * @param 識別コード 識別コード
     * @return RString
     */
    public RString tasichosonTokureiChofukuCheck(List<Tashichoson> tashichoson, ShikibetsuCode 識別コード) {
        List<Idokikan> 資格取得年月日情報被保険者台帳 = get資格取得年月日情報By被保険者台帳(識別コード);
        Idokikan 資格取得年月日情報適用除外者 = get資格取得年月日情報By適用除外者(識別コード);
        if (!資格取得年月日情報被保険者台帳.isEmpty()
                && 資格取得年月日情報適用除外者 != null) {
            List<Idokikan> idokikanList = new ArrayList<>();
            idokikanList.addAll(資格取得年月日情報被保険者台帳);
            idokikanList.add(資格取得年月日情報適用除外者);
            idokikanList.addAll(get資格取得年月日情報By引数Tashichoson(tashichoson));
            if (!chofukuCheck(idokikanList)) {
                return ERR_CODE_DBAE00008;
            }
        }
        return RString.EMPTY;
    }

    private List<Idokikan> get資格取得年月日情報By引数TokusoRireki(List<TokusoRireki> tokusoRireki) {
        List<Idokikan> idokikanList = new ArrayList<>();
        if (tokusoRireki != null && !tokusoRireki.isEmpty()) {
            for (TokusoRireki 資格取得年月日 : tokusoRireki) {
                Idokikan idokikan = new Idokikan();
                idokikan.setKaishiYMD(資格取得年月日.getKaishiYMD());
                idokikan.setShuryoYMD(資格取得年月日.getShuryoYMD());
                idokikanList.add(idokikan);
            }
        }
        return idokikanList;
    }

    private List<Idokikan> get資格取得年月日情報By引数TekiyoJogaisha(List<TekiyoJogaisha> tekiyoJogaisha) {
        List<Idokikan> idokikanList = new ArrayList<>();
        if (tekiyoJogaisha != null && !tekiyoJogaisha.isEmpty()) {
            for (TekiyoJogaisha tokusoRireki : tekiyoJogaisha) {
                Idokikan idokikan = new Idokikan();
                idokikan.setKaishiYMD(tokusoRireki.getKaishiYMD());
                idokikan.setShuryoYMD(tokusoRireki.getShuryoYMD());
                idokikanList.add(idokikan);
            }
        }
        return idokikanList;
    }

    private List<Idokikan> get資格取得年月日情報By引数Tashichoson(List<Tashichoson> tashichoson) {
        List<Idokikan> idokikanList = new ArrayList<>();
        if (tashichoson != null && !tashichoson.isEmpty()) {
            for (Tashichoson 資格取得年月日 : tashichoson) {
                Idokikan idokikan = new Idokikan();
                idokikan.setKaishiYMD(資格取得年月日.getKaishiYMD());
                idokikan.setShuryoYMD(資格取得年月日.getShuryoYMD());
                idokikanList.add(idokikan);
            }
        }
        return idokikanList;
    }

    private List<Idokikan> get資格取得年月日情報By被保険者台帳(ShikibetsuCode 識別コード) {
        List<Idokikan> idokikanList = new ArrayList<>();
        ISikakuIdoCheckMapper mapper = mapperProvider.create(ISikakuIdoCheckMapper.class);
        List<DbT1001HihokenshaDaichoEntity> dbt1001 = mapper.getDbT1001HihokenshaDaicho(識別コード);
        for (DbT1001HihokenshaDaichoEntity entity : dbt1001) {
            DbT1001HihokenshaDaichoEntity 資格取得年月日 = mapper.getDbT1001Hihokensha(entity.getHihokenshaNo());
            Idokikan idokikan = new Idokikan();
            idokikan.setKaishiYMD(資格取得年月日.getShikakuShutokuYMD());
            idokikan.setShuryoYMD(資格取得年月日.getShikakuSoshitsuYMD());
            idokikanList.add(idokikan);
        }
        return idokikanList;
    }

    private Idokikan get資格取得年月日情報By他市町村住所地特例(ShikibetsuCode 識別コード) {
        ISikakuIdoCheckMapper mapper = mapperProvider.create(ISikakuIdoCheckMapper.class);
        DbT1003TashichosonJushochiTokureiEntity entity = mapper.getDbT1003TashichosonJushochiTokurei(識別コード);
        if (entity != null) {
            Idokikan idokikan = new Idokikan();
            idokikan.setKaishiYMD(entity.getTekiyoYMD());
            idokikan.setShuryoYMD(entity.getKaijoYMD());
            return idokikan;
        }
        return null;
    }

    private Idokikan get資格取得年月日情報By適用除外者(ShikibetsuCode 識別コード) {
        ISikakuIdoCheckMapper mapper = mapperProvider.create(ISikakuIdoCheckMapper.class);
        DbT1002TekiyoJogaishaEntity entity = mapper.getDbT1002TekiyoJogaisha(識別コード);
        if (entity != null) {
            Idokikan idokikan = new Idokikan();
            idokikan.setKaishiYMD(entity.getTekiyoYMD());
            idokikan.setShuryoYMD(entity.getKaijoYMD());
            return idokikan;
        }
        return null;
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
}
