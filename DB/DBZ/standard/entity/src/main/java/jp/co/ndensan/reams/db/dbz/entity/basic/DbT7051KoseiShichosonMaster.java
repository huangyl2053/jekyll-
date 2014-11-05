package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT7051KoseiShichosonMasterの項目定義クラスです
 *
 */
public enum DbT7051KoseiShichosonMaster implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    shichosonShokibetsuID(2, 0),
    shichosonCode(2147483647, 0),
    shoKisaiHokenshaNo(2147483647, 0),
    kokuhorenKoikiShichosonNo(3, 0),
    shichosonMeisho(10, 0),
    todofukenMeisho(4, 0),
    gunMeisho(8, 0),
    yubinNo(2147483647, 0),
    jusho(2147483647, 0),
    telNo(2147483647, 0),
    yusenChikuCode(1, 0),
    tyohyoTodoufukenHyojiUmu(1, 0),
    tyohyoGunHyojiUmu(1, 0),
    tyohyoShichosonHyojiUmu(1, 0),
    tyohyoJushoHenshuHouhou(1, 0),
    tyohyoKatagakiHyojiUmu(1, 0),
    gaikokujinHyojiHouhou(1, 0),
    rojinhokenShichosonNo(8, 0),
    rokenJukyushaNoTaikei(1, 0),
    ikoYMD(2147483647, 0),
    kanyuYMD(2147483647, 0),
    ridatsuYMD(2147483647, 0),
    gappeiKyuShichosonKubun(1, 0),
    gappeiKyuShichosonHyojiUmu(1, 0),
    gappeiLinkNo(2, 0),
    unyoHokenshaNo(2147483647, 0),
    unyoKaishiYMD(2147483647, 0),
    unyoShuryoYMD(2147483647, 0),
    unyoKeitaiKubun(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT7051KoseiShichosonMaster(int maxLength, int scale) {
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
