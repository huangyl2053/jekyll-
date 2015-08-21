package jp.co.ndensan.reams.db.dbx.realservice;

import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbx.business.IKaigoHokenJukyusha;
import jp.co.ndensan.reams.db.dbx.definition.enumeratedtype.YoKaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbx.business.mapper.KaigoHokenJukyushaMapper;
import jp.co.ndensan.reams.db.dbx.entity.relate.KaigohokenJukyushaAndKojinEntity;
import jp.co.ndensan.reams.db.dbx.persistence.relate.IKaigoHokenJukyushaDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 介護保険受給者照会クラスです。
 *
 * @author N2806 太田 智之
 * @jpName 介護保険受給者取得
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護保険受給者
 * @mainClass
 * @reference
 */
public class _KaigoHokenJukyushaFinder implements IKaigoHokenJukyushaFinder {

    private final IKaigoHokenJukyushaDac jukyushaDac;

    /**
     * テスト用コンストラクタです。
     *
     * @param dac 使用するテスト用のDACクラス
     */
    _KaigoHokenJukyushaFinder(IKaigoHokenJukyushaDac jukyushaDac) {
        this.jukyushaDac = jukyushaDac;
    }

    /**
     * コンストラクタです。
     */
    public _KaigoHokenJukyushaFinder() {
        this.jukyushaDac = InstanceProvider.createWithCustomize(IKaigoHokenJukyushaDac.class);
    }

    @Override
    public IKaigoHokenJukyusha get要介護受給者(ShikibetsuCode 識別コード) {
        Objects.requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        KaigohokenJukyushaAndKojinEntity jukyusha = jukyushaDac.select(識別コード.value(), RDate.getNowDate());
        if (jukyusha == null) {
            return null;
        }
        return KaigoHokenJukyushaMapper.toKaigotoKaigoHokenJukyusha(jukyusha);
    }

    @Override
    public IKaigoHokenJukyusha get要介護受給者(ShikibetsuCode 識別コード, RDate 基準日) {
        Objects.requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        Objects.requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage("基準日"));
        KaigohokenJukyushaAndKojinEntity jukyusha = jukyushaDac.select(識別コード.value(), 基準日);
        if (jukyusha == null) {
            return null;
        }
        return KaigoHokenJukyushaMapper.toKaigotoKaigoHokenJukyusha(jukyusha);
    }

    @Override
    public IKaigoHokenJukyusha get要介護受給者履歴(ShikibetsuCode 識別コード) {
        Objects.requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        List<KaigohokenJukyushaAndKojinEntity> jukyusha = jukyushaDac.select(識別コード.value());
        return KaigoHokenJukyushaMapper.toKaigotoKaigoHokenJukyusha(jukyusha);
    }

    @Override
    public List<IKaigoHokenJukyusha> get要介護受給者リスト(YoKaigoJotaiKubun from要介護状態区分, YoKaigoJotaiKubun to要介護状態区分) {
        Objects.requireNonNull(from要介護状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("from要介護状態区分"));
        Objects.requireNonNull(to要介護状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("to要介護状態区分"));
        List<KaigohokenJukyushaAndKojinEntity> jukyusha = jukyushaDac.select(from要介護状態区分, to要介護状態区分, RDate.getNowDate());
        return KaigoHokenJukyushaMapper.toKaigotoKaigoHokenJukyushaList(jukyusha);
    }
}
