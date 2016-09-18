/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.setaiinshotokujoho;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SetaiinJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SetaiinShotoku;
import jp.co.ndensan.reams.db.dbz.business.core.view.KaigoShotokuAlive;
import jp.co.ndensan.reams.db.dbz.service.core.basic.HihokenshaDaichoManager;
import jp.co.ndensan.reams.db.dbz.service.core.kyufu.KogakuServicehiTaishoshaManager;
import jp.co.ndensan.reams.db.dbz.service.core.setai.SetaiinFinder;
import jp.co.ndensan.reams.db.dbz.service.core.view.ShotokuManager;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 世帯員の所得情報を管理するクラスです。
 */
public class SetaiinShotokuJohoFinder {

    // private final MapperProvider mapperProvider;
    private final SetaiinFinder 世帯員Finder;
    private final HihokenshaDaichoManager 被保険者台帳Manager;
    private final ShotokuManager 介護所得Manager;
    private final KogakuServicehiTaishoshaManager 高額対象者情報有無Manager;

    /**
     * コンストラクタです。
     */
    public SetaiinShotokuJohoFinder() {
        // this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.世帯員Finder = SetaiinFinder.createInstance();
        this.被保険者台帳Manager = HihokenshaDaichoManager.createInstance();
        this.介護所得Manager = ShotokuManager.createInstance();
        this.高額対象者情報有無Manager = KogakuServicehiTaishoshaManager.createInstance();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param 被保険者台帳Manager 被保険者台帳Manager
     * @param 介護所得Manager 介護所得Manager
     */
    SetaiinShotokuJohoFinder(
            // MapperProvider mapperProvider,
            SetaiinFinder 世帯員Finder,
            HihokenshaDaichoManager 被保険者台帳Manager, ShotokuManager 介護所得Manager, KogakuServicehiTaishoshaManager 高額対象者情報有無Manager) {
        // this.mapperProvider = mapperProvider;
        this.世帯員Finder = 世帯員Finder;
        this.被保険者台帳Manager = 被保険者台帳Manager;
        this.介護所得Manager = 介護所得Manager;
        this.高額対象者情報有無Manager = 高額対象者情報有無Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SetaiinFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link SetaiinFinder}のインスタンス
     */
    public static SetaiinShotokuJohoFinder createInstance() {
        return InstanceProvider.create(SetaiinShotokuJohoFinder.class);
    }

    /**
     * キーに合致する世帯員所得情報リストを返します。
     *
     * @param 識別コード 識別コード
     * @param 世帯基準年月日 世帯基準年月日
     * @param 所得年度 所得年度
     * @param 所得基準年月日 所得基準年月日
     * @param 給付情報取得有無 給付情報取得有無
     * @return 世帯員所得情報リスト
     */
    @Transaction
    public List<SetaiinShotoku> get世帯員所得情報(ShikibetsuCode 識別コード, FlexibleDate 世帯基準年月日,
            FlexibleYear 所得年度, YMDHMS 所得基準年月日, boolean 給付情報取得有無) {
        requireNonNull(識別コード, UrErrorMessages.検索キーの誤り.getMessage().toString());
        requireNonNull(所得年度, UrErrorMessages.検索キーの誤り.getMessage().toString());
        requireNonNull(給付情報取得有無, UrErrorMessages.検索キーの誤り.getMessage().toString());

        if (世帯基準年月日 == null) {
            世帯基準年月日 = FlexibleDate.getNowDate();
        }
        if (所得基準年月日 == null) {
            所得基準年月日 = YMDHMS.now();
        }
        List<SetaiinJoho> 世帯員リスト = 世帯員Finder.get世帯員情報By識別コード(識別コード, 世帯基準年月日);
        if (世帯員リスト.isEmpty()) {
            return new ArrayList();
        }
        List<SetaiinShotoku> 世帯員所得情報リスト = new ArrayList();
        boolean 高額対象者情報有無 = false;
        //TODO 動作優先でループ内のDBアクセス実装となっている。修正が必要。
        //TODO 給付実績より同月サービス情報を取得部分は未実装
        for (SetaiinJoho 世帯員 : 世帯員リスト) {
            HihokenshaDaicho 被保険者台帳 = 被保険者台帳Manager.find最新被保険者台帳(世帯員.get識別対象().get識別コード());
            KaigoShotokuAlive 介護所得 = 介護所得Manager.get介護所得AliveFromMapper(所得年度, 所得基準年月日, 世帯員.get識別対象().to個人().get識別コード());
            if (被保険者台帳 != null && 給付情報取得有無) {
                高額対象者情報有無 = 高額対象者情報有無Manager.is高額対象者有無(被保険者台帳.get被保険者番号(), 世帯基準年月日);
            } else {
                高額対象者情報有無 = false;
            }
            世帯員所得情報リスト.add(new SetaiinShotoku(
                    世帯員.get識別対象().get識別コード(),
                    被保険者台帳 != null ? 被保険者台帳.get被保険者番号() : new HihokenshaNo(RString.EMPTY),
                    世帯員.get識別対象().get名称().getName().value(),
                    世帯員.get識別対象().get名称().getKana().value(),
                    世帯員.get生年月日(),
                    世帯員.get性別().getCode(),
                    世帯員.get性別().getCommonName(),
                    世帯員.get続柄コード(),
                    世帯員.get続柄(),
                    世帯員.get住民状態().コード(),
                    世帯員.get住民状態().住民状態略称(),
                    介護所得 != null ? 介護所得.get課税区分_住民税減免前() : RString.EMPTY,
                    介護所得 != null ? 介護所得.get課税区分_住民税減免後() : RString.EMPTY,
                    介護所得 != null ? 介護所得.get激変緩和措置() : RString.EMPTY,
                    介護所得 != null ? 介護所得.get合計所得金額() : null,
                    介護所得 != null ? 介護所得.get年金収入額() : null,
                    介護所得 != null ? 介護所得.get年金所得額() : null,
                    介護所得 != null ? 介護所得.get課税所得額() : null,
                    介護所得 != null ? 介護所得.get登録業務() : RString.EMPTY,
                    介護所得 != null ? new FlexibleDate(介護所得.get更正日().getDate().toDateString()) : new FlexibleDate(RString.EMPTY),
                    高額対象者情報有無,
                    世帯員.get識別対象().get異動年月日(),
                    世帯員.get住定異動年月日(),
                    世帯員.get識別対象().get異動事由().get異動事由コード(),
                    世帯員.get識別対象().get異動事由().get異動事由正式名称(),
                    世帯員.get住民票表示順(),
                    世帯員.get本人区分(),
                    世帯員.get世帯コード().value()));
        }
        return 世帯員所得情報リスト;
    }

    /**
     * キーに合致する世帯員所得情報リストを返します。
     *
     * @param 識別コード 識別コード
     * @param 所得年度 所得年度
     * @param 所得基準年月日 所得基準年月日
     * @return 世帯員所得情報リスト
     */
    @Transaction
    public List<SetaiinShotoku> get世帯員所得情報(ShikibetsuCode 識別コード, FlexibleYear 所得年度, YMDHMS 所得基準年月日) {
        requireNonNull(識別コード, UrErrorMessages.検索キーの誤り.getMessage().toString());
        requireNonNull(所得年度, UrErrorMessages.検索キーの誤り.getMessage().toString());
        if (所得基準年月日 == null) {
            所得基準年月日 = YMDHMS.now();
        }
        List<SetaiinJoho> 世帯員情報リスト = 世帯員Finder.get所得情報登録用世帯員情報(識別コード);
        if (世帯員情報リスト.isEmpty()) {
            return new ArrayList();
        }
        List<SetaiinShotoku> 世帯員所得情報リスト = new ArrayList();
        for (SetaiinJoho 世帯員所得 : 世帯員情報リスト) {
            if (世帯員所得.get識別対象().get住民種別().equals(JuminShubetsu.共有者)
                    || 世帯員所得.get識別対象().get住民種別().equals(JuminShubetsu.法人)) {
                continue;
            }
            HihokenshaDaicho 被保険者台帳 = 被保険者台帳Manager.find最新被保険者台帳(世帯員所得.get識別対象().get識別コード());
            KaigoShotokuAlive 介護所得 = 介護所得Manager.get介護所得AliveFromMapper(所得年度, 所得基準年月日, 世帯員所得.get識別対象().to個人().get識別コード());
            世帯員所得情報リスト.add(new SetaiinShotoku(
                    世帯員所得.get識別対象().to個人().get識別コード(),
                    被保険者台帳 != null ? 被保険者台帳.get被保険者番号() : new HihokenshaNo(RString.EMPTY),
                    世帯員所得.get識別対象().get名称().getName().value(),
                    世帯員所得.get識別対象().get名称().getKana().value(),
                    世帯員所得.get生年月日(),
                    世帯員所得.get性別().getCode(),
                    世帯員所得.get性別().getCommonName(),
                    世帯員所得.get続柄コード(),
                    世帯員所得.get続柄(),
                    世帯員所得.get住民状態().コード(),
                    世帯員所得.get住民状態().住民状態略称(),
                    介護所得 != null ? 介護所得.get課税区分_住民税減免前() : RString.EMPTY,
                    介護所得 != null ? 介護所得.get課税区分_住民税減免後() : RString.EMPTY,
                    介護所得 != null ? 介護所得.get激変緩和措置() : RString.EMPTY,
                    介護所得 != null ? 介護所得.get合計所得金額() : null,
                    介護所得 != null ? 介護所得.get年金収入額() : null,
                    介護所得 != null ? 介護所得.get年金所得額() : null,
                    介護所得 != null ? 介護所得.get課税所得額() : null,
                    介護所得 != null ? 介護所得.get登録業務() : RString.EMPTY,
                    介護所得 != null ? new FlexibleDate(介護所得.get更正日().getDate().toDateString()) : new FlexibleDate(RString.EMPTY),
                    false,
                    世帯員所得.get識別対象().get異動年月日(),
                    世帯員所得.get住定異動年月日(),
                    世帯員所得.get識別対象().get異動事由().get異動事由コード(),
                    世帯員所得.get識別対象().get異動事由().get異動事由正式名称(),
                    世帯員所得.get住民票表示順(),
                    世帯員所得.get本人区分(),
                    世帯員所得.get世帯コード().value()));
        }
        return 世帯員所得情報リスト;
    }
}
