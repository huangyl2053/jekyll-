/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc050010;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 振込データ登録_口座振込一時情報SQL用パラメタークラスです．
 *
 * @reamsid_L DBC-2180-030 x_lilh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FurikomiDataTourokuMybatisParameter implements IMyBatisParameter {

    private static final RString 登録区分_通常 = new RString("1");
    private static final RString 登録区分_差分 = new RString("2");

    private KinyuKikanCode 代表金融機関コード;
    private RString 振込グループコード;
    private RDate 振込指定年月日;
    private RString 登録区分;

    /**
     * コンストラクタです。
     */
    public FurikomiDataTourokuMybatisParameter() {
    }

    /**
     * コンストラクタです。
     *
     * @param 代表金融機関コード 代表金融機関コード
     * @param 振込グループコード 振込グループコード
     * @param 振込指定年月日 振込指定年月日
     * @param 再処理フラグ 再処理フラグ
     */
    public FurikomiDataTourokuMybatisParameter(KinyuKikanCode 代表金融機関コード,
            RString 振込グループコード,
            RDate 振込指定年月日,
            boolean 再処理フラグ) {
        this.代表金融機関コード = 代表金融機関コード;
        this.振込グループコード = 振込グループコード;
        this.振込指定年月日 = 振込指定年月日;
        edit登録区分(再処理フラグ);
    }

    private void edit登録区分(boolean 再処理フラグ) {
        if (再処理フラグ) {
            登録区分 = 登録区分_通常;
        } else {
            登録区分 = 登録区分_差分;
        }
    }
}
