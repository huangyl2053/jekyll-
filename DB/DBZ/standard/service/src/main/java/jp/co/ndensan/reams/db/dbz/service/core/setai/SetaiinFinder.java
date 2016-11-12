/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.setai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KaigoSetai;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SetaiinJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SetaiinShikibetsuCd;
import jp.co.ndensan.reams.db.dbz.definition.core.honninkubun.HonninKubun;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.setai.SetaiinParameter;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.setai.ISetaiinMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.basic.HihokenshaDaichoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.KaigoSetaiManager;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojins;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.setai.ISetai;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.SetaiinShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.IShikibetsuTaishoFinder;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.setai.ISetaiFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 世帯員を管理するクラスです。
 *
 * @reamsid_L DBB-1750-030 sunhui
 */
public class SetaiinFinder {

    private final MapperProvider mapperProvider;
    private final HihokenshaDaichoManager 被保険者台帳Manager;
    private final KaigoSetaiManager 介護世帯Manager;
    private static final int 最大のリスト = 50;
    private static final RString RSTR_ZERO = new RString("0");
    private static final RString RSTR_ONE = new RString("1");
    private static final RString RSTR_TWO = new RString("2");

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
        if (被保険者台帳情報 == null || !RSTR_ONE.equals(被保険者台帳情報.get住所地特例フラグ())) {
            ISetaiFinder 世帯Finder = ShikibetsuTaishoService.getSetaiFinder();
            ISetai 世帯 = 世帯Finder.findBy識別コード住民のみ(GyomuCode.DB介護保険, 識別コード, 基準年月日);
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
     * 指定した識別コードに合致する世帯員リストを返します。
     *
     * @param 識別コード 識別コード
     * @param 基準年月日 基準年月日
     * @return 世帯員識別コードリスト
     */
    @Transaction
    public IKojins get世帯員リスト(ShikibetsuCode 識別コード, FlexibleDate 基準年月日) {
        requireNonNull(識別コード, UrErrorMessages.検索キーの誤り.getMessage().toString());
        requireNonNull(基準年月日, UrErrorMessages.検索キーの誤り.getMessage().toString());

        ISetaiFinder 世帯Finder = ShikibetsuTaishoService.getSetaiFinder();
        ISetai 世帯 = 世帯Finder.findBy識別コード住民のみ(GyomuCode.DB介護保険, 識別コード, 基準年月日);
        if (世帯 == null) {
            return null;
        } else {
            return 世帯.get世帯員リスト();
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
        requireNonNull(世帯員識別コードリスト, UrErrorMessages.検索キーの誤り.getMessage().toString());
        requireNonNull(基準年月日, UrErrorMessages.検索キーの誤り.getMessage().toString());
        List<SetaiinJoho> 世帯員情報リスト = new ArrayList();
        for (SetaiinShikibetsuCd 世帯員 : 世帯員識別コードリスト) {
            IShikibetsuTaishoFinder 識別対象Finder = ShikibetsuTaishoService.getShikibetsuTaishoFinder();
            IShikibetsuTaisho 識別対象 = 識別対象Finder.get識別対象(GyomuCode.DB介護保険,
                    世帯員.get世帯員識別コード(), KensakuYusenKubun.住登外優先);
            if (!世帯員.get世帯員識別コード().isEmpty() && 識別対象 != null && !識別対象.get識別コード().isEmpty()) {
                RString 本人区分 = 世帯員.get本人区分();
                SetaiinJoho 世帯員情報 = new SetaiinJoho(識別対象, 本人区分);
                世帯員情報リスト.add(世帯員情報);
            }
        }
        return 世帯員情報リスト;
    }

    /**
     * 所得照会票用世帯員情報リストを返します。
     *
     * @param 識別コード 識別コード
     * @return 所得照会票用世帯員情報リスト
     */
    public List<SetaiinJoho> get所得照会票用世帯員情報(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrErrorMessages.検索キーの誤り.getMessage().toString());

        List<SetaiinJoho> 世帯員情報リスト = new ArrayList<>();
        ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険,
                KensakuYusenKubun.住登内優先);
        builder.set世帯員取得区分(SetaiinShutokuKubun.世帯員を取得する);
        builder.set識別コード(識別コード);
        IShikibetsuTaishoPSMSearchKey searchKey = builder.build();
        SetaiinParameter parameter = new SetaiinParameter(searchKey);
        ISetaiinMapper mapper = mapperProvider.create(ISetaiinMapper.class);
        List<UaFt200FindShikibetsuTaishoEntity> resultList = mapper.get宛名識別対象PSM(parameter);
        List<IShikibetsuTaisho> 識別対象list = new ArrayList<>();

        Collections.sort(resultList, new Comparator<UaFt200FindShikibetsuTaishoEntity>() {
            @Override
            public int compare(UaFt200FindShikibetsuTaishoEntity entity1, UaFt200FindShikibetsuTaishoEntity entity2) {
                RString str1 = new RString(String.valueOf(entity1.getJuminhyoHyojijun()));
                RString str2 = new RString(String.valueOf(entity2.getJuminhyoHyojijun()));
                return str1.compareTo(str2);
            }
        });

        for (UaFt200FindShikibetsuTaishoEntity 宛名識別対象Entity : resultList) {
            IShikibetsuTaishoFinder 識別対象Finder = ShikibetsuTaishoService.getShikibetsuTaishoFinder();
            IShikibetsuTaisho 識別対象 = 識別対象Finder.get識別対象(GyomuCode.DB介護保険,
                    宛名識別対象Entity.getShikibetsuCode(), KensakuYusenKubun.住登外優先);
            識別対象list.add(識別対象);
        }
        List<SetaiinJoho> リスト = null;
        boolean 本人データフラグ = false;
        for (IShikibetsuTaisho 宛名識別対象 : 識別対象list) {
            リスト = new ArrayList<>();
            if (識別コード.equals(宛名識別対象.get識別コード())) {
                if (本人データフラグ) {
                    continue;
                }
                IShikibetsuTaisho 識別対象 = 宛名識別対象;
                RString 本人区分 = RSTR_ONE;
                SetaiinJoho setaiinJoho = new SetaiinJoho(識別対象, 本人区分);
                世帯員情報リスト.add(setaiinJoho);
                本人データフラグ = true;
            } else {
                IShikibetsuTaisho 識別対象 = 宛名識別対象;
                RString 本人区分 = RSTR_ZERO;
                SetaiinJoho setaiinJoho = new SetaiinJoho(識別対象, 本人区分);
                世帯員情報リスト.add(setaiinJoho);
            }
            リスト.addAll(世帯員情報リスト);
            if (リスト.size() == 最大のリスト) {
                return リスト;
            }
        }
        return リスト;
    }

    /**
     * 所得情報登録用世帯員情報リストを返します。
     *
     * @param 識別コード 識別コード
     * @return 所得情報登録用世帯員情報リスト
     */
    public List<SetaiinJoho> get所得情報登録用世帯員情報(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrErrorMessages.検索キーの誤り.getMessage().toString());

        SetaiinJoho setaiinJoho;
        List<SetaiinJoho> 世帯員情報リスト = new ArrayList<>();
        ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険,
                KensakuYusenKubun.住登内優先);
        builder.set世帯員取得区分(SetaiinShutokuKubun.世帯員を取得する);
        builder.set識別コード(識別コード);
        IShikibetsuTaishoPSMSearchKey searchKey = builder.build();
        SetaiinParameter parameter = new SetaiinParameter(searchKey);
        ISetaiinMapper mapper = mapperProvider.create(ISetaiinMapper.class);
        List<UaFt200FindShikibetsuTaishoEntity> resultList = mapper.get宛名識別対象PSM(parameter);
        if (resultList.isEmpty()) {
            return new ArrayList<>();
        }

        Collections.sort(resultList, new Comparator<UaFt200FindShikibetsuTaishoEntity>() {
            @Override
            public int compare(UaFt200FindShikibetsuTaishoEntity entity1, UaFt200FindShikibetsuTaishoEntity entity2) {
                RString str1 = new RString(String.valueOf(entity1.getJuminhyoHyojijun()));
                RString str2 = new RString(String.valueOf(entity2.getJuminhyoHyojijun()));
                return str1.compareTo(str2);
            }
        });

        for (UaFt200FindShikibetsuTaishoEntity 宛名識別対象Entity : resultList) {

            IShikibetsuTaisho 宛名識別対象 = ShikibetsuTaishoFactory.createShikibetsuTaisho(宛名識別対象Entity);

            if (識別コード.equals(宛名識別対象Entity.getShikibetsuCode())) {
                IShikibetsuTaisho 識別対象 = 宛名識別対象;
                RString 本人区分 = RSTR_ONE;
                setaiinJoho = new SetaiinJoho(識別対象, 本人区分);
            } else {
                IShikibetsuTaisho 識別対象 = 宛名識別対象;
                RString 本人区分 = RSTR_TWO;
                setaiinJoho = new SetaiinJoho(識別対象, 本人区分);
            }
            世帯員情報リスト.add(setaiinJoho);
        }

        Collections.sort(世帯員情報リスト, new Comparator<SetaiinJoho>() {
            @Override
            public int compare(SetaiinJoho entity1, SetaiinJoho entity2) {
                return entity1.get本人区分().compareTo(entity2.get本人区分());
            }
        });
        return 世帯員情報リスト;
    }

}
