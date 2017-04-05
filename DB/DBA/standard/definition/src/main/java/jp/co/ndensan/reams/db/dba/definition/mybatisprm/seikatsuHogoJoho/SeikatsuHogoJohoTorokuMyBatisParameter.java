/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatisprm.seikatsuHogoJoho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 生活保護情報登録リスト出力のDBパラメータを定義するクラスです。
 *
 * @
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class SeikatsuHogoJohoTorokuMyBatisParameter {

    private RString shikibetsuCode;
    private boolean jukyushaFalg;
    private RString jukyushaNo;
    private RString gyomuCode;

    private SeikatsuHogoJohoTorokuMyBatisParameter(RString shikibetsuCode,
            RString jukyushaNo, RString gyomuCode, boolean jukyushaFalg) {
        this.shikibetsuCode = shikibetsuCode;
        this.jukyushaNo = jukyushaNo;
        this.gyomuCode = gyomuCode;
        this.jukyushaFalg = jukyushaFalg;
    }

    /**
     * 生活保護情報登録のパラメタを 取得します。
     *
     * @param shikibetsuCode 識別コード
     * @param jukyushaNo 受給者番号
     * @param gyomuCode 業務コード
     * @return 生活保護情報登録のパラメタ
     */
    public static SeikatsuHogoJohoTorokuMyBatisParameter createSelectByKeyParameter(RString shikibetsuCode,
            RString jukyushaNo, RString gyomuCode) {
        boolean jukyushaFalg = true;
        if (jukyushaNo.isEmpty()) {
            jukyushaFalg = false;
        }
        return new SeikatsuHogoJohoTorokuMyBatisParameter(shikibetsuCode, jukyushaNo, gyomuCode, jukyushaFalg);
    }
}
