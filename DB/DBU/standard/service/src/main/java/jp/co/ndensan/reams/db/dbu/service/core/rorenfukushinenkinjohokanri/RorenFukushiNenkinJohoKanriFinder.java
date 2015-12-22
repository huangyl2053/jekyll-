/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.rorenfukushinenkinjohokanri;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbu.definition.core.rorenfukushinenkinjohokanri.RorenFukushiNenkinJohoKanriParameter;
import jp.co.ndensan.reams.db.dbu.persistence.mapper.basic.rorenfukushinenkinjohokanri.RorenFukushiNenkinJohoKanriMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 老齢福祉年金受給者台帳管理です。
 *
 */
public class RorenFukushiNenkinJohoKanriFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    RorenFukushiNenkinJohoKanriFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);

    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link RorenFukushiNenkinJohoKanriFinder} のインスタンスを返します。
     *
     * @return RorenFukushiNenkinJohoKanriFinder
     */
    public static RorenFukushiNenkinJohoKanriFinder createInstance() {
        return InstanceProvider.create(RorenFukushiNenkinJohoKanriFinder.class);

    }

    /**
     * 受給期間重複チェックを処理します。
     *
     * @param shikibetsuCode 識別コード
     * @param jukyuKaishiYMD 受給開始年月日
     * @param hihokenshaNo 被保険者番号
     * @param jukyuShuryoYMD 受給終了年月日
     * @return boolean 受給期間重複フラグ(true: 重複する、false: 重複しない)
     */
    @Transaction
    public boolean jukyuKikanJufukuCheck(ShikibetsuCode shikibetsuCode, FlexibleDate jukyuKaishiYMD,
            HihokenshaNo hihokenshaNo, FlexibleDate jukyuShuryoYMD) {
        requireNonNull(shikibetsuCode, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(jukyuKaishiYMD, UrSystemErrorMessages.値がnull.getReplacedMessage("受給開始年月日"));
        requireNonNull(hihokenshaNo, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(jukyuShuryoYMD, UrSystemErrorMessages.値がnull.getReplacedMessage("受給終了年月日"));
        RorenFukushiNenkinJohoKanriMapper mapper = mapperProvider.create(RorenFukushiNenkinJohoKanriMapper.class);
        RorenFukushiNenkinJohoKanriParameter param = RorenFukushiNenkinJohoKanriParameter.createParam_RoreiFukushi(
                shikibetsuCode, jukyuKaishiYMD, hihokenshaNo, jukyuShuryoYMD);
        int count = mapper.jukyuKikanJufukuCheck(param);
        return count != 0;
    }
}
