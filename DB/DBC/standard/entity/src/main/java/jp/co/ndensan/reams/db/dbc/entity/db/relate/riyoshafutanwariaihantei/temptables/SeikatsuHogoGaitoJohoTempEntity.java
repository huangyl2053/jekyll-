/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 * 生活保護該当情報の一時表エンティティです。
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SeikatsuHogoGaitoJohoTempEntity extends DbTableEntityBase<SeikatsuHogoGaitoJohoTempEntity> implements IDbAccessable {

    //対象年度
    private RString taishoNendo;
    //対象月
    private RString taishoTsuki;
    //識別コード
    @PrimaryKey
    private ShikibetsuCode shikibetsuCode;
    //受給開始日
    @PrimaryKey
    private RString jukyuKaishiYMD;
    //受給廃止日
    private RString jukyuHaishiYMD;

}
