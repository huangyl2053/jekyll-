/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyodojukyushainsub;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushainsub.DbWT5C31KihonKyoudouShoriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushainsub.DbWT5C32ShoukanKyoudouShoriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushainsub.DbWT5C33KougakuKyoudouShoriEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 共同処理用受給者情報クラスです。
 *
 * @reamsid_L DBC-2780-011 lishengli
 */
public class KyoudouShoriYouJukyuusyaJouhou {

    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_7 = 7;
    private static final int INDEX_8 = 8;
    private static final int INDEX_9 = 9;
    private static final int INDEX_10 = 10;
    private static final int INDEX_11 = 11;
    private static final int INDEX_12 = 12;
    private static final int INDEX_13 = 13;
    private static final int INDEX_14 = 14;
    private static final int INDEX_15 = 15;
    private final RString 保険者番号;

    /**
     * コンストラクタです。
     *
     * @param 保険者番号 保険者番号
     */
    public KyoudouShoriYouJukyuusyaJouhou(RString 保険者番号) {
        this.保険者番号 = 保険者番号;
    }

    /**
     * 基本共同処理一時TBLのEntityの設定処理です。
     *
     * @param csvData List<RString>
     * @param 保険者名 保険者名
     * @return 基本共同処理一時TBLのEntity
     */
    public DbWT5C31KihonKyoudouShoriEntity getDbWT5C31Entity(List<RString> csvData, RString 保険者名) {
        DbWT5C31KihonKyoudouShoriEntity entity = new DbWT5C31KihonKyoudouShoriEntity();
        entity.setHokenshaNo(保険者番号);
        entity.setHokenshaName(保険者名);
        entity.setShikibetsuNo(get項目(csvData, 2));
        entity.setIdoYMD(get項目(csvData, INDEX_3));
        entity.setIdoKubunCode(get項目(csvData, INDEX_4));
        entity.setTeiseiYMD(get項目(csvData, INDEX_5));
        entity.setTeiseiKubunCode(get項目(csvData, INDEX_6));
        entity.setJukyushaIdoJiyu(get項目(csvData, INDEX_7));
        entity.setShoKisaiHokenshaNo(get項目(csvData, INDEX_8));
        entity.setHiHokenshaNo(get項目(csvData, INDEX_9));
        entity.setHiHokenshaName(get項目(csvData, INDEX_10));
        entity.setTelNo(get項目(csvData, INDEX_11));
        entity.setYubinNo(get項目(csvData, INDEX_12));
        entity.setDdressKana(get項目(csvData, INDEX_13));
        entity.setAddress(get項目(csvData, INDEX_14));
        entity.setChohyoOutputJunjyoCode(get項目(csvData, INDEX_15));
        return entity;
    }

    /**
     * 基本共同処理一時TBLのEntityの設定処理です。
     *
     * @param csvData List<RString>
     * @param 保険者名 保険者名
     * @return 基本共同処理一時TBLのEntity
     */
    public DbWT5C31KihonKyoudouShoriEntity getDbWT5C41Entity(List<RString> csvData, RString 保険者名) {
        DbWT5C31KihonKyoudouShoriEntity entity = new DbWT5C31KihonKyoudouShoriEntity();
        entity.setHokenshaNo(保険者番号);
        entity.setHokenshaName(保険者名);
        entity.setShikibetsuNo(get項目(csvData, 2));
        entity.setIdoYMD(get項目(csvData, INDEX_3));
        entity.setTeiseiYMD(get項目(csvData, INDEX_4));
        entity.setIdoKubunCode(get項目(csvData, INDEX_5));
        entity.setJukyushaIdoJiyu(get項目(csvData, INDEX_6));
        entity.setShoKisaiHokenshaNo(get項目(csvData, INDEX_7));
        entity.setHiHokenshaNo(get項目(csvData, INDEX_8));
        entity.setHiHokenshaName(get項目(csvData, INDEX_9));
        entity.setYubinNo(get項目(csvData, INDEX_10));
        entity.setDdressKana(get項目(csvData, INDEX_11));
        entity.setAddress(get項目(csvData, INDEX_12));
        entity.setTelNo(get項目(csvData, INDEX_13));
        entity.setChohyoOutputJunjyoCode(get項目(csvData, INDEX_14));
        return entity;
    }

    /**
     * 償還共同処理一時TBLのEntityの設定処理です。
     *
     * @param csvData List<RString>
     * @param 保険者名 保険者名
     * @return 償還共同処理一時TBLのEntity
     */
    public DbWT5C32ShoukanKyoudouShoriEntity getDbWT5D31Entity(List<RString> csvData, RString 保険者名) {
        DbWT5C32ShoukanKyoudouShoriEntity entity = new DbWT5C32ShoukanKyoudouShoriEntity();
        entity.setHokenshaNo(保険者番号);
        entity.setHokenshaName(保険者名);
        entity.setShikibetsuNo(get項目(csvData, 2));
        entity.setIdoYMD(get項目(csvData, INDEX_3));
        entity.setIdoKubunCode(get項目(csvData, INDEX_4));
        entity.setTeiseiYMD(get項目(csvData, INDEX_5));
        entity.setTeiseiKubunCode(get項目(csvData, INDEX_6));
        entity.setJukyushaIdoJiyu(get項目(csvData, INDEX_7));
        entity.setShoKisaiHokenshaNo(get項目(csvData, INDEX_8));
        entity.setHiHokenshaNo(get項目(csvData, INDEX_9));
        entity.setHokenKyufuIchijiSashitomeKaishiYMD(get項目(csvData, INDEX_10));
        entity.setHokenKyufuIchijiSashitomeShuryoYMD(get項目(csvData, INDEX_11));
        entity.setHokenkyufuIchijiSashitomeKubunCode(get項目(csvData, INDEX_12));
        entity.setHokenkyufuIchijiSashitomeKingaku(get項目(csvData, INDEX_13));
        return entity;
    }

    /**
     * 償還共同処理一時TBLのEntityの設定処理です。
     *
     * @param csvData List<RString>
     * @param 保険者名 保険者名
     * @return 償還共同処理一時TBLのEntity
     */
    public DbWT5C32ShoukanKyoudouShoriEntity getDbWT5D41Entity(List<RString> csvData, RString 保険者名) {
        DbWT5C32ShoukanKyoudouShoriEntity entity = new DbWT5C32ShoukanKyoudouShoriEntity();
        entity.setHokenshaNo(保険者番号);
        entity.setHokenshaName(保険者名);
        entity.setShikibetsuNo(get項目(csvData, 2));
        entity.setIdoYMD(get項目(csvData, INDEX_3));
        entity.setTeiseiYMD(get項目(csvData, INDEX_4));
        entity.setIdoKubunCode(get項目(csvData, INDEX_5));
        entity.setJukyushaIdoJiyu(get項目(csvData, INDEX_6));
        entity.setShoKisaiHokenshaNo(get項目(csvData, INDEX_7));
        entity.setHiHokenshaNo(get項目(csvData, INDEX_8));
        entity.setHokenKyufuIchijiSashitomeKaishiYMD(get項目(csvData, INDEX_9));
        entity.setHokenKyufuIchijiSashitomeShuryoYMD(get項目(csvData, INDEX_10));
        entity.setHokenkyufuIchijiSashitomeKubunCode(get項目(csvData, INDEX_11));
        entity.setHokenkyufuIchijiSashitomeKingaku(get項目(csvData, INDEX_12));
        return entity;
    }

    /**
     * 高額共同処理一時TBLのEntityの設定処理です。
     *
     * @param csvData List<RString>
     * @param 保険者名 保険者名
     * @return 高額共同処理一時TBLのEntity
     */
    public DbWT5C33KougakuKyoudouShoriEntity getDbWT5E31Entity(List<RString> csvData, RString 保険者名) {
        DbWT5C33KougakuKyoudouShoriEntity entity = new DbWT5C33KougakuKyoudouShoriEntity();
        entity.setHokenshaNo(保険者番号);
        entity.setHokenshaName(保険者名);
        entity.setShikibetsuNo(get項目(csvData, 2));
        entity.setIdoYMD(get項目(csvData, INDEX_3));
        entity.setIdoKubunCode(get項目(csvData, INDEX_4));
        entity.setTeiseiYMD(get項目(csvData, INDEX_5));
        entity.setTeiseiKubunCode(get項目(csvData, INDEX_6));
        entity.setJukyushaIdoJiyu(get項目(csvData, INDEX_7));
        entity.setShoKisaiHokenshaNo(get項目(csvData, INDEX_8));
        entity.setHiHokenshaNo(get項目(csvData, INDEX_9));
        entity.setSetaiShuyakuNo(get項目(csvData, INDEX_10));
        entity.setSetaiShotokuKubunCode(get項目(csvData, INDEX_11));
        entity.setShotokuKubunCode(get項目(csvData, INDEX_12));
        entity.setRoureiFukushiNenkinJukyuAriFlag(get項目(csvData, INDEX_13));
        entity.setRiyoshaFutan2DankaiAriFlag(get項目(csvData, INDEX_14));
        entity.setShikyuShinseishoOutputAriFlag(get項目(csvData, INDEX_15));
        return entity;
    }

    /**
     * 高額共同処理一時TBLのEntityの設定処理です。
     *
     * @param csvData List<RString>
     * @param 保険者名 保険者名
     * @return 高額共同処理一時TBLのEntity
     */
    public DbWT5C33KougakuKyoudouShoriEntity getDbWT5E41Entity(List<RString> csvData, RString 保険者名) {
        DbWT5C33KougakuKyoudouShoriEntity entity = new DbWT5C33KougakuKyoudouShoriEntity();
        entity.setHokenshaNo(保険者番号);
        entity.setHokenshaName(保険者名);
        entity.setShikibetsuNo(get項目(csvData, 2));
        entity.setIdoYMD(get項目(csvData, INDEX_3));
        entity.setTeiseiYMD(get項目(csvData, INDEX_4));
        entity.setIdoKubunCode(get項目(csvData, INDEX_5));
        entity.setJukyushaIdoJiyu(get項目(csvData, INDEX_6));
        entity.setShoKisaiHokenshaNo(get項目(csvData, INDEX_7));
        entity.setHiHokenshaNo(get項目(csvData, INDEX_8));
        entity.setSetaiShuyakuNo(get項目(csvData, INDEX_9));
        entity.setSetaiShotokuKubunCode(get項目(csvData, INDEX_10));
        entity.setShotokuKubunCode(get項目(csvData, INDEX_11));
        entity.setRoureiFukushiNenkinJukyuAriFlag(get項目(csvData, INDEX_12));
        entity.setRiyoshaFutan2DankaiAriFlag(get項目(csvData, INDEX_13));
        entity.setShikyuShinseishoOutputAriFlag(get項目(csvData, INDEX_14));
        return entity;
    }

    private RString get項目(List<RString> data, int index) {
        if (index < data.size()) {
            return data.get(index);
        }
        return RString.EMPTY;
    }
}
