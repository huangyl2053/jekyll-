/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.realservice;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbx.business.IKogakuKaigoServiceHi;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbV3057KogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbx.business.mapper.KogakuKaigoServiceHiMapper;
import jp.co.ndensan.reams.db.dbx.persistence.basic.KogakuKaigoServiceHiDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額介護サービス費を取得するクラスです。
 *
 * @author N9943 王 永康
 * @jpName 高額介護サービス費取得
 * @bizDomain 介護
 * @category 高額介護給付費
 * @subCategory
 * @mainClass
 * @reference
 */
public class _KogakuKaigoServiceHiFinder implements IKogakuKaigoServiceHiFinder {

    private final KogakuKaigoServiceHiDac kogakuKaigoServiceHiDac;

    /**
     * コンストラクター
     */
    public _KogakuKaigoServiceHiFinder() {
        kogakuKaigoServiceHiDac = new KogakuKaigoServiceHiDac();
    }

    /**
     * テスト用コンストラクター
     *
     * @param dac テスト用個人DAC
     */
    _KogakuKaigoServiceHiFinder(KogakuKaigoServiceHiDac dac) {
        this.kogakuKaigoServiceHiDac = dac;
    }

    /**
     * {@inheritDoc}
     *
     * @throws NullPointerException 引数がnullの場合はスローされる
     */
    @Override
    public IKogakuKaigoServiceHi get支給情報(RString 被保険者番号, FlexibleYearMonth 対象年月) throws NullPointerException {
        Objects.requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        Objects.requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        DbV3057KogakuShikyuHanteiKekkaEntity entity = kogakuKaigoServiceHiDac.select(被保険者番号, 対象年月);
        if (entity == null) {
            return null;
        }
        return KogakuKaigoServiceHiMapper.toKogakuKaigoServiceHi(entity);
    }
}
