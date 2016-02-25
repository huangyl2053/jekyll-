/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.setai;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KaigoSetai;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SetaiinJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SetaiinShikibetsuCd;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.HonninKubun;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.basic.HihokenshaDaichoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.KaigoSetaiManager;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojins;
//import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.setai.ISetai;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
//import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.IShikibetsuTaishoFinder;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.setai.ISetaiFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 世帯員を管理するクラスです。
 */
public class SetaiinFinder {

    private final MapperProvider mapperProvider;
    private final HihokenshaDaichoManager 被保険者台帳Manager;
    private final KaigoSetaiManager 介護世帯Manager;

    /**
     * コンストラクタです。
     */
    public SetaiinFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.被保険者台帳Manager = new HihokenshaDaichoManager();
        this.介護世帯Manager = new KaigoSetaiManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 被保険者台帳Manager 被保険者台帳Manager
     * @param 介護世帯Manager 介護世帯Manager
     */
    SetaiinFinder(MapperProvider mapperProvider, HihokenshaDaichoManager 被保険者台帳Manager, KaigoSetaiManager 介護世帯Manager) {
        this.mapperProvider = mapperProvider;
        this.被保険者台帳Manager = 被保険者台帳Manager;
        this.介護世帯Manager = 介護世帯Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SetaiinFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link SetaiinFinder}のインスタンス
     */
    public static SetaiinFinder createInstance() {
        return InstanceProvider.create(SetaiinFinder.class);
    }

    /**
     * 指定した被保険者番号に合致する世帯員の識別コードリストを返します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 基準年月日 基準年月日
     * @return 世帯員識別コードリスト
     */
    @Transaction
    public List<SetaiinShikibetsuCd> get世帯員識別コードBy被保番号(HihokenshaNo 被保険者番号, FlexibleDate 基準年月日) {
        requireNonNull(被保険者番号, UrErrorMessages.検索キーの誤り.getMessage().toString());
        requireNonNull(基準年月日, UrErrorMessages.検索キーの誤り.getMessage().toString());
        HihokenshaDaicho 被保険者台帳情報 = 被保険者台帳Manager.find被保険者台帳(被保険者番号, 基準年月日);
        if (被保険者台帳情報 == null) {
            return new ArrayList();
        }
        List<KaigoSetai> 介護世帯情報 = 介護世帯Manager.get介護世帯By被保番号(被保険者番号, 基準年月日);
        if (介護世帯情報.isEmpty()) {
            return get世帯員識別コード(被保険者台帳情報.get識別コード(), 基準年月日);
        } else {
            List<SetaiinShikibetsuCd> 介護世帯識別コードリスト = new ArrayList();
            for (KaigoSetai 介護世帯 : 介護世帯情報) {
                介護世帯識別コードリスト.add(new SetaiinShikibetsuCd(SetaiCode.EMPTY, 介護世帯.get世帯員識別コード(), 介護世帯.get本人区分()));
            }
            return 介護世帯識別コードリスト;
        }
    }

    /**
     * 指定した識別コードに合致する世帯員の識別コードリストを返します。
     *
     * @param 識別コード 識別コード
     * @param 基準年月日 基準年月日
     * @return 世帯員識別コードリスト
     */
    @Transaction
    public List<SetaiinShikibetsuCd> get世帯員識別コードBy識別コード(ShikibetsuCode 識別コード, FlexibleDate 基準年月日) {
        requireNonNull(識別コード, UrErrorMessages.検索キーの誤り.getMessage().toString());
        requireNonNull(基準年月日, UrErrorMessages.検索キーの誤り.getMessage().toString());
        HihokenshaDaicho 被保険者台帳情報 = 被保険者台帳Manager.find最新被保険者台帳(識別コード);
        if (被保険者台帳情報 == null) {
            return get世帯員識別コード(識別コード, 基準年月日);
        } else {
            return get世帯員識別コードBy被保番号(被保険者台帳情報.get被保険者番号(), 基準年月日);
        }
    }

    /**
     * 指定した被保険者番号に合致する世帯員情報リストを返します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 基準年月日 基準年月日
     * @return 世帯員情報リスト
     */
    @Transaction
    public List<SetaiinJoho> get世帯員情報By被保番号(HihokenshaNo 被保険者番号, FlexibleDate 基準年月日) {
        requireNonNull(被保険者番号, UrErrorMessages.検索キーの誤り.getMessage().toString());
        requireNonNull(基準年月日, UrErrorMessages.検索キーの誤り.getMessage().toString());
        List<SetaiinShikibetsuCd> 世帯員識別コードリスト = get世帯員識別コードBy被保番号(被保険者番号, 基準年月日);
        return get世帯員情報(世帯員識別コードリスト, 基準年月日);
    }

    /**
     * 指定した識別コードに合致する世帯員情報リストを返します。
     *
     * @param 識別コード 識別コード
     * @param 基準年月日 基準年月日
     * @return 世帯員情報リスト
     */
    @Transaction
    public List<SetaiinJoho> get世帯員情報By識別コード(ShikibetsuCode 識別コード, FlexibleDate 基準年月日) {
        requireNonNull(識別コード, UrErrorMessages.検索キーの誤り.getMessage().toString());
        requireNonNull(基準年月日, UrErrorMessages.検索キーの誤り.getMessage().toString());
        HihokenshaDaicho 被保険者台帳情報 = 被保険者台帳Manager.find最新被保険者台帳(識別コード);
        if (被保険者台帳情報 == null) {
            List<SetaiinShikibetsuCd> 世帯員識別コードリスト = get世帯員識別コード(識別コード, 基準年月日);
            return get世帯員情報(世帯員識別コードリスト, 基準年月日);
        } else {
            return get世帯員情報By被保番号(被保険者台帳情報.get被保険者番号(), 基準年月日);
        }
    }

    /**
     * 指定した識別コードに合致する世帯員の識別コードリストを返します。
     *
     * @param 識別コード 識別コード
     * @param 基準年月日 基準年月日
     * @return 世帯員識別コードリスト
     */
    @Transaction
    public List<SetaiinShikibetsuCd> get世帯員識別コード(ShikibetsuCode 識別コード, FlexibleDate 基準年月日) {
        requireNonNull(識別コード, UrErrorMessages.検索キーの誤り.getMessage().toString());
        requireNonNull(基準年月日, UrErrorMessages.検索キーの誤り.getMessage().toString());

        HihokenshaDaicho 被保険者台帳情報 = 被保険者台帳Manager.find被保険者台帳(識別コード, 基準年月日);
        List<SetaiinShikibetsuCd> 世帯員識別コードリスト = new ArrayList();
        if (被保険者台帳情報 == null || !被保険者台帳情報.get住所地特例フラグ().equals(new RString("1"))) {
            ISetaiFinder 世帯Finder = ShikibetsuTaishoService.getSetaiFinder();
            ISetai 世帯 = 世帯Finder.findBy識別コード(GyomuCode.DB介護保険, 識別コード, 基準年月日);
            if (世帯 == null) {
                return new ArrayList();
            } else {
                IKojins 世帯員リスト = 世帯.get世帯員リスト();
                for (IKojin 世帯員 : 世帯員リスト) {
                    RString 本人区分 = 識別コード.equals(世帯員.get識別コード()) ? HonninKubun.本人.getCode() : HonninKubun.世帯構成員.getCode();
                    世帯員識別コードリスト.add(new SetaiinShikibetsuCd(世帯員.get世帯コード(), 世帯員.get識別コード(), 本人区分));
                }
            }
            return 世帯員識別コードリスト;
        } else {
            世帯員識別コードリスト.add(new SetaiinShikibetsuCd(null, 被保険者台帳情報.get識別コード(), HonninKubun.本人.getCode()));
            return 世帯員識別コードリスト;
        }

    }

    /**
     * 指定した識別コードリストに合致する世帯員の宛名情報（住登外優先）リストを返します。
     *
     * @param 世帯員識別コードリスト 世帯員識別コードリスト
     * @param 基準年月日 基準年月日
     * @return 世帯員宛名情報（住登外優先）リスト
     */
    @Transaction
    public List<SetaiinJoho> get世帯員情報(List<SetaiinShikibetsuCd> 世帯員識別コードリスト, FlexibleDate 基準年月日) {
        requireNonNull(世帯員識別コードリスト, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯員識別コードリスト"));
        requireNonNull(基準年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("基準年月日"));
        List<SetaiinJoho> 世帯員情報リスト = new ArrayList();
        for (SetaiinShikibetsuCd 世帯員 : 世帯員識別コードリスト) {
            IShikibetsuTaishoFinder 識別対象Finder = ShikibetsuTaishoService.getShikibetsuTaishoFinder();
            IShikibetsuTaisho 識別対象 = 識別対象Finder.get識別対象(GyomuCode.DB介護保険,
                    世帯員.get世帯員識別コード(), KensakuYusenKubun.住登外優先);
            RString 本人区分 = 世帯員.get世帯員識別コード().equals(識別対象.get識別コード())
                    ? HonninKubun.本人.getCode() : HonninKubun.世帯構成員.getCode();
            SetaiinJoho 世帯員情報 = new SetaiinJoho(識別対象, 本人区分);
            世帯員情報リスト.add(世帯員情報);
        }
        return 世帯員情報リスト;
    }

    /**
     * 所得照会票用世帯員情報リストを返します。
     *
     * @return 所得照会票用世帯員情報リスト
     */
    public List<SetaiinJoho> get所得照会票用世帯員情報() {
        //TODO:処理内容について未精査のため実装されていません。
        return new ArrayList();
    }

    /**
     * 所得情報登録用世帯員情報リストを返します。
     *
     * @return 所得情報登録用世帯員情報リスト
     */
    public List<SetaiinJoho> get所得情報登録用世帯員情報() {
        //TODO:処理内容について未精査のため実装されていません。
        return new ArrayList();
    }

}
