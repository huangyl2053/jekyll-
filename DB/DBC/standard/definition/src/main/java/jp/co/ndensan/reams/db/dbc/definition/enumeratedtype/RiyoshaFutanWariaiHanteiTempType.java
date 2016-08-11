/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 利用者負担割合判定のテンポラリテーブルの列挙クラスです。
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
public enum RiyoshaFutanWariaiHanteiTempType {

    /**
     * EMPTY
     */
    EMPTY("", ""),
    /**
     * 判定対象者Temp
     */
    判定対象者("HanteiTaishoshaTemp", "HanteiTaishoshaTempEntity"),
    /**
     * 月別判定対象者Temp
     */
    月別判定対象者("TsukibetsuHanteiTaishoshaTemp", "HanteiTaishoshaTempEntity"),
    /**
     * 世帯員情報Temp
     */
    世帯員情報("SetainJohoTemp", "SetaiinJohoTempEntity"),
    /**
     * 追加判定対象者Temp
     */
    追加判定対象者("TuikaHanteiTaishoshaTemp", "SetaiinJohoTempEntity"),
    /**
     * 世帯員把握入力Temp
     */
    世帯員把握入力("SetainHakuNyuryokuTemp", "SetaiHaakuEntity"),
    /**
     * 世帯員所得情報Temp
     */
    世帯員所得情報("TmpSetaiShotoku", "SetaiShotokuEntity"),
    /**
     * 生活保護該当情報Temp
     */
    生活保護該当情報("SeikatsuHogoGaitoJohoTemp", "UrT0508SeikatsuHogoJukyushaEntity"),
    /**
     * 利用者負担割合明細Temp
     */
    利用者負担割合明細("RiyoshaFutanWariaiMeisaiTemp", "RiyoshaFutanWariaiMeisaiTempEntity"),
    /**
     * 利用者負担割合明細01Temp
     */
    利用者負担割合明細01("RiyoshaFutanWariaiMeisai01Temp", "RiyoshaFutanWariaiMeisaiTempEntity"),
    /**
     * 利用者負担割合明細02Temp
     */
    利用者負担割合明細02("RiyoshaFutanWariaiMeisai02Temp", "RiyoshaFutanWariaiMeisaiTempEntity"),
    /**
     * 利用者負担割合明細03Temp
     */
    利用者負担割合明細03("RiyoshaFutanWariaiMeisai03Temp", "RiyoshaFutanWariaiMeisaiTempEntity"),
    /**
     * 利用者負担割合明細04Temp
     */
    利用者負担割合明細04("RiyoshaFutanWariaiMeisai04Temp", "RiyoshaFutanWariaiMeisaiTempEntity"),
    /**
     * 利用者負担割合明細05Temp
     */
    利用者負担割合明細05("RiyoshaFutanWariaiMeisai05Temp", "RiyoshaFutanWariaiMeisaiTempEntity"),
    /**
     * 利用者負担割合明細06Temp
     */
    利用者負担割合明細06("RiyoshaFutanWariaiMeisai06Temp", "RiyoshaFutanWariaiMeisaiTempEntity"),
    /**
     * 利用者負担割合明細07Temp
     */
    利用者負担割合明細07("RiyoshaFutanWariaiMeisai07Temp", "RiyoshaFutanWariaiMeisaiTempEntity"),
    /**
     * 利用者負担割合明細08Temp
     */
    利用者負担割合明細08("RiyoshaFutanWariaiMeisai08Temp", "RiyoshaFutanWariaiMeisaiTempEntity"),
    /**
     * 利用者負担割合明細09Temp
     */
    利用者負担割合明細09("RiyoshaFutanWariaiMeisai09Temp", "RiyoshaFutanWariaiMeisaiTempEntity"),
    /**
     * 利用者負担割合明細10Temp
     */
    利用者負担割合明細10("RiyoshaFutanWariaiMeisai10Temp", "RiyoshaFutanWariaiMeisaiTempEntity"),
    /**
     * 利用者負担割合明細11Temp
     */
    利用者負担割合明細11("RiyoshaFutanWariaiMeisai11Temp", "RiyoshaFutanWariaiMeisaiTempEntity"),
    /**
     * 利用者負担割合明細12Temp
     */
    利用者負担割合明細12("RiyoshaFutanWariaiMeisai12Temp", "RiyoshaFutanWariaiMeisaiTempEntity"),
    /**
     * 利用者負担割合根拠Temp
     */
    利用者負担割合根拠("RiyoshaFutanWariaiKonkyoTemp", "DbT3115RiyoshaFutanWariaiKonkyoEntity"),
    /**
     * 月別負担割合_新Temp
     */
    月別負担割合_新("TsukibetsuFutanWariaiNewTemp", "TsukibetsuFutanWariaiTempEntity"),
    /**
     * 月別負担割合_現Temp
     */
    月別負担割合_現("TsukibetsuFutanWariaiGenTemp", "TsukibetsuFutanWariaiTempEntity"),
    /**
     * 今回利用者負担割合情報Temp
     */
    今回利用者負担割合情報("KonkaiRiyoshaFutanWariaiJohoTemp", "KonkaiRiyoshaFutanWariaiJohoTempEntity");
    private RString tableName;
    private RString entityName;

    private RiyoshaFutanWariaiHanteiTempType() {
        this.tableName = RString.EMPTY;
        this.entityName = RString.EMPTY;
    }

    private RiyoshaFutanWariaiHanteiTempType(String tableName, String entityName) {
        this.tableName = new RString(tableName);
        this.entityName = new RString(entityName);
    }

    /**
     * tableNameを返します。
     *
     * @return tableName
     */
    public RString getTableName() {
        return tableName;
    }

    /**
     * entityNameを返します。
     *
     * @return entityName
     */
    public RString getEntityName() {
        return this.entityName;
    }

    /**
     * 対応する列挙型を返します。
     * <p/>
     * @param tableOrEntity tableOrEntity
     * @return 列挙型
     * @throws IllegalArgumentException 対応する列挙型がない場合
     */
    public static RiyoshaFutanWariaiHanteiTempType toValue(RString tableOrEntity) throws IllegalArgumentException {
        if (RString.isNullOrEmpty(tableOrEntity)) {
            return EMPTY;
        }
        for (RiyoshaFutanWariaiHanteiTempType data : values()) {
            if (data.getTableName().equals(tableOrEntity) || data.getEntityName().equals(tableOrEntity)) {
                return data;
            }
        }
        return EMPTY;
    }
}
