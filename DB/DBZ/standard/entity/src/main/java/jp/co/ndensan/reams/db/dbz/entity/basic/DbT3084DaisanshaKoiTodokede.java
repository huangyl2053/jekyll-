package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3084DaisanshaKoiTodokedeの項目定義クラスです
 *
 */
public enum DbT3084DaisanshaKoiTodokede implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    hihokenshaNo(2147483647, 0),
    todokedeKanriNo(10, 0),
    shoriTimestamp(2147483647, 0),
    todokedeYMD(2147483647, 0),
    todokedenin_YubinNo(2147483647, 0),
    todokedenin_Jusho(100, 0),
    todokedenin_ShimeiKana(2147483647, 0),
    todokedenin_Shimei(2147483647, 0),
    todokedenin_TelNo(2147483647, 0),
    todokedenin_Zokugara(20, 0),
    yokaigoJotaiKubun(2147483647, 0),
    ninteiYukoKaishiYMD(2147483647, 0),
    ninteiYukoShuryoYMD(2147483647, 0),
    kagaisha_YubinNo(2147483647, 0),
    kagaisha_Jusho(100, 0),
    kagaisha_ShimeiKana(2147483647, 0),
    kagansha_Shimei(2147483647, 0),
    kagaisha_UmareYMD(2147483647, 0),
    kagaisha_TelNo(2147483647, 0),
    kagaisha_Shokugyo(50, 0),
    shiyosha_YubinNo(2147483647, 0),
    shiyosha_Jusho(100, 0),
    shiyosha_ShimeiKana(2147483647, 0),
    shiyosha_Shimei(2147483647, 0),
    shiyosha_UmareYMD(2147483647, 0),
    shiyosha_TelNo(2147483647, 0),
    shiyosha_Shokugyo(50, 0),
    fushoYMD(2147483647, 0),
    fushoTime(4, 0),
    fushoJi_Basho(100, 0),
    hasshoGeiin_FushoJiJokyo(500, 0),
    jibaisekiHoken_KeiyakuKaishaMei(2147483647, 0),
    jibaisekiHoken_ShomeishoNo(50, 0),
    jibaisekiHoken_KeiyakushaJusho(100, 0),
    shoyushaJusho(100, 0),
    shoyushaShimei(2147483647, 0),
    torokuNo(50, 0),
    shadaiNo(50, 0),
    niniHoken_TaijinHoshoUmu(1, 0),
    niniHoken_TaijinHoshoKaishaMei(2147483647, 0),
    niniHoken_TaijinHoshoKaishaTelNo(2147483647, 0),
    niniHoken_TaijinHoshoKaishaTantosha(2147483647, 0),
    jidan_SeiritsuUmu(1, 0),
    jidan_SeiritsuYMD(2147483647, 0),
    songaiBaishoKoshoKeika(100, 0),
    jikoHasseiJokyoHokokushoUmu(1, 0),
    nensho_DoishoUmu(1, 0),
    seiyakushoUmu(1, 0),
    kotsuJikoShomeishoUmu(1, 0),
    jinshinJikoShomeisho_NyushuFunoRiyushoUmu(1, 0),
    jidanshoUtsushiUmu(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT3084DaisanshaKoiTodokede(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    /**
     * getMaxLength
     * @return 項目の最大長
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * getScale
     * @return 小数点以下の桁数
     */
    public int getScale() {
        return scale;
    }

// </editor-fold>
}
