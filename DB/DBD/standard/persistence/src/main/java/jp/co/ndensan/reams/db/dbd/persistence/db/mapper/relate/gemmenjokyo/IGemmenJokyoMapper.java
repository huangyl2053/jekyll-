/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmenjokyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmenjokyo.GemmenJokyoParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.common.NursingCareInformationCodeEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.futangendogakunintei.FutanGendogakuNinteiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.homonkaigogengaku.HomonKaigoRiyoshaFutangakuGengakuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengakuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.shafukukeigen.ShafukuRiyoshaFutanKeigenEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuchiikiKasanGemmenEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;

/**
 *
 * 減免照会（画面） Mapper
 *
 * @reamsid_L DBD-4342-020 wangjie2
 */
public interface IGemmenJokyoMapper {

    /**
     * 要介護認定情報を取得します。
     *
     * @param parameter パラメータク
     * @return List<NursingCareInformationCodeEntity>
     */
    List<NursingCareInformationCodeEntity> get要介護認定情報(GemmenJokyoParameter parameter);

    /**
     * 老齢年金情報を取得します。
     *
     * @param parameter パラメータク
     * @return DbT7006RoreiFukushiNenkinJukyushaEntity
     */
    DbT7006RoreiFukushiNenkinJukyushaEntity get老齢年金情報(GemmenJokyoParameter parameter);

    /**
     * 支払方法変更情報を取得します。
     *
     * @param parameter パラメータク
     * @return List<DbT4021ShiharaiHohoHenkoEntity>
     */
    List<DbT4021ShiharaiHohoHenkoEntity> get支払方法変更情報(GemmenJokyoParameter parameter);

    /**
     * 利用者負担割合明細を取得します。
     *
     * @param parameter パラメータク
     * @return List<DbT3114RiyoshaFutanWariaiMeisaiEntity>
     */
    List<DbT3114RiyoshaFutanWariaiMeisaiEntity> get利用者負担割合明細(GemmenJokyoParameter parameter);

    /**
     * 介護保険負担限度額認定の情報を取得します。
     *
     * @param parameter パラメータク
     * @return FutanGendogakuNinteiEntity
     */
    FutanGendogakuNinteiEntity get介護保険負担限度額認定の情報(GemmenJokyoParameter parameter);

    /**
     * 利用者負担額減額の情報を取得します。
     *
     * @param parameter パラメータク
     * @return RiyoshaFutangakuGengakuEntity
     */
    RiyoshaFutangakuGengakuEntity get利用者負担額減額の情報(GemmenJokyoParameter parameter);

    /**
     * 社会福祉法人等利用者負担軽減の情報を取得します。
     *
     * @param parameter パラメータク
     * @return ShafukuRiyoshaFutanKeigenEntity
     */
    ShafukuRiyoshaFutanKeigenEntity get社会福祉法人等利用者負担軽減の情報(GemmenJokyoParameter parameter);

    /**
     * 訪問介護利用者負担額減額の情報を取得します。
     *
     * @param parameter パラメータク
     * @return HomonKaigoRiyoshaFutangakuGengakuEntity
     */
    HomonKaigoRiyoshaFutangakuGengakuEntity get訪問介護利用者負担額減額の情報(GemmenJokyoParameter parameter);

    /**
     * 特別地域加算減免の情報を取得します。
     *
     * @param parameter パラメータク
     * @return HomonKaigoRiyoshaFutangakuGengakuEntity
     */
    TokubetsuchiikiKasanGemmenEntity get特別地域加算減免の情報(GemmenJokyoParameter parameter);

}
