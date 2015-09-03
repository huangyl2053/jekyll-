package jp.co.ndensan.reams.db.dbx.realservice;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbx.business.mapper.KaigoHokenJukyushaMapper;
import jp.co.ndensan.reams.db.dbx.entity.relate.KaigohokenJukyushaAndKojinEntity;
import jp.co.ndensan.reams.db.dbx.persistence.relate.IKaigoHokenJukyushaDac;
import jp.co.ndensan.reams.db.dbx.business.IKobetsuJikoKaigoJukyu;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 介護受給を管理するクラスです。
 *
 * @author N2218 村松 優
 * @jpName 受給台帳取得
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護保険受給者
 * @mainClass
 * @reference
 */
public class _JukyuDaichoFinder implements IJukyuDaichoFinder {

    private final IKaigoHokenJukyushaDac jukyushaDac;

    /**
     * コンストラクタです。
     */
    public _JukyuDaichoFinder() {
        this.jukyushaDac = InstanceProvider.createWithCustomize(IKaigoHokenJukyushaDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param dac テスト用介護保険受給者DAC
     */
    _JukyuDaichoFinder(IKaigoHokenJukyushaDac jukyushaDac) {
        this.jukyushaDac = jukyushaDac;
    }

    @Override
    public IKobetsuJikoKaigoJukyu get個別事項介護受給(ShikibetsuCode 識別コード, RDate 基準日) {
        Objects.requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        Objects.requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage("基準日"));
        KaigohokenJukyushaAndKojinEntity jukyusha = jukyushaDac.select(識別コード.value(), 基準日);
        if (jukyusha == null) {
            return null;
        }
        return KaigoHokenJukyushaMapper.toKobetsuJikoKaigoJukyu(jukyusha, 基準日);
    }
}
