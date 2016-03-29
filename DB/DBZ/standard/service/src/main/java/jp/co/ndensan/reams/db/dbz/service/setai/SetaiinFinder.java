/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.setai;

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
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.setai.SetaiinParameter;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.setai.ISetaiinMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.basic.HihokenshaDaichoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.KaigoSetaiManager;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
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
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 世帯員取得
 */
public class SetaiinFinder {

    private final MapperProvider mapperProvider;
    private static final int 最大のリスト = 50;

    /**
     * コンストラクタ
     */
    public SetaiinFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    public SetaiinFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
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
     * 世帯員識別コード取得by被保番号
     *
     * @param 被保険者番号 被保険者番号
     * @param 基準年月日 基準年月日
     * @return 世帯員識別コードリスト
     */
    public List<SetaiinShikibetsuCd> get世帯員識別コードBy被保番号(HihokenshaNo 被保険者番号, FlexibleDate 基準年月日) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(基準年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("基準年月日"));

        List<SetaiinShikibetsuCd> 世帯員識別コードリスト = new ArrayList<>();
        HihokenshaDaichoManager manager = new HihokenshaDaichoManager();
        HihokenshaDaicho 被保台帳 = manager.find被保険者台帳(被保険者番号, 基準年月日);
        if (null == 被保台帳) {
            return 世帯員識別コードリスト;
        }

        KaigoSetaiManager kaigosetaiManager = new KaigoSetaiManager();
        List<KaigoSetai> kaigoSetaiList = kaigosetaiManager.get介護世帯By被保番号(被保険者番号, 基準年月日);

        if (kaigoSetaiList.isEmpty()) {
            世帯員識別コードリスト = get世帯員識別コード(被保台帳.get識別コード(), 基準年月日);
        } else {
            SetaiCode 世帯コード = null;
            ShikibetsuCode 世帯員識別コード = kaigoSetaiList.get(0).get世帯員識別コード();
            RString 本人区分 = kaigoSetaiList.get(0).get本人区分();
            SetaiinShikibetsuCd 世帯員識別コードの管理 = new SetaiinShikibetsuCd(世帯コード, 世帯員識別コード, 本人区分);
            世帯員識別コードリスト.add(世帯員識別コードの管理);
        }

        return 世帯員識別コードリスト;
    }

    /**
     * 世帯員識別コード取得by識別コード
     *
     * @param 識別コード 識別コード
     * @param 基準年月日 基準年月日
     * @return 世帯員識別コードリスト
     */
    public List<SetaiinShikibetsuCd> get世帯員識別コードBy識別コード(ShikibetsuCode 識別コード, FlexibleDate 基準年月日) {
        requireNonNull(基準年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("基準年月日"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

        List<SetaiinShikibetsuCd> 世帯員識別コードリスト;
        HihokenshaDaichoManager manager = new HihokenshaDaichoManager();
        HihokenshaDaicho 被保台帳 = manager.find最新被保険者台帳(識別コード);
        if (null == 被保台帳) {
            世帯員識別コードリスト = get世帯員識別コード(識別コード, 基準年月日);
        } else {
            世帯員識別コードリスト = get世帯員識別コードBy被保番号(被保台帳.get被保険者番号(), 基準年月日);
        }
        return 世帯員識別コードリスト;
    }

    /**
     * 世帯員宛名情報取得by被保番号
     *
     * @param 被保険者番号 被保険者番号
     * @param 基準年月日 基準年月日
     * @return 世帯員情報リスト
     */
    public List<SetaiinJoho> get世帯員情報By被保番号(HihokenshaNo 被保険者番号, FlexibleDate 基準年月日) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(基準年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("基準年月日"));

        List<SetaiinShikibetsuCd> 世帯員識別コードリスト = get世帯員識別コードBy被保番号(被保険者番号, 基準年月日);
        return get世帯員情報(世帯員識別コードリスト, 基準年月日);
    }

    /**
     * 世帯員宛名情報取得by識別コード
     *
     * @param 識別コード 識別コード
     * @param 基準年月日 基準年月日
     * @return 世帯員情報リスト
     */
    public List<SetaiinJoho> get世帯員情報By識別コード(ShikibetsuCode 識別コード, FlexibleDate 基準年月日) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(基準年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("基準年月日"));

        List<SetaiinJoho> 世帯員情報リスト;
        HihokenshaDaichoManager manager = new HihokenshaDaichoManager();
        HihokenshaDaicho 被保険者台帳 = manager.find最新被保険者台帳(識別コード);
        if (null == 被保険者台帳) {
            List<SetaiinShikibetsuCd> 世帯員識別コードリスト = get世帯員識別コード(識別コード, 基準年月日);
            世帯員情報リスト = get世帯員情報(世帯員識別コードリスト, 基準年月日);
        } else {
            世帯員情報リスト = get世帯員情報By被保番号(被保険者台帳.get被保険者番号(), 基準年月日);
        }

        return 世帯員情報リスト;
    }

    /**
     * 所得照会票用世帯員情報取得
     *
     * @param 識別コード 識別コード
     * @return 世帯員情報リスト
     */
    public List<SetaiinJoho> get所得照会票用世帯員情報(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

        List<SetaiinJoho> 世帯員情報リスト = new ArrayList<>();
        ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険,
                KensakuYusenKubun.住登内優先);
        builder.set世帯員取得区分(SetaiinShutokuKubun.世帯員を取得する);
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
        for (IShikibetsuTaisho 宛名識別対象 : 識別対象list) {
            if (識別コード.equals(宛名識別対象.get識別コード())) {
                IShikibetsuTaisho 識別対象 = 宛名識別対象;
                RString 本人区分 = new RString("1");
                SetaiinJoho setaiinJoho = new SetaiinJoho(識別対象, 本人区分);
                世帯員情報リスト.add(setaiinJoho);
            } else {
                IShikibetsuTaisho 識別対象 = 宛名識別対象;
                RString 本人区分 = new RString("0");
                SetaiinJoho setaiinJoho = new SetaiinJoho(識別対象, 本人区分);
                世帯員情報リスト.add(setaiinJoho);
            }
            if (世帯員情報リスト.size() == 最大のリスト) {
                return 世帯員情報リスト;
            }
        }
        return 世帯員情報リスト;
    }

    /**
     * 所得情報登録用世帯員情報取得
     *
     * @param 識別コード 識別コード
     * @return 世帯員情報リスト
     */
    public List<SetaiinJoho> get所得情報登録用世帯員情報(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

        SetaiinJoho setaiinJoho;
        List<SetaiinJoho> 世帯員情報リスト = new ArrayList<>();
        ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険,
                KensakuYusenKubun.住登内優先);
        builder.set世帯員取得区分(SetaiinShutokuKubun.世帯員を取得する);
        IShikibetsuTaishoPSMSearchKey searchKey = builder.build();
        SetaiinParameter parameter = new SetaiinParameter(searchKey);
        ISetaiinMapper mapper = mapperProvider.create(ISetaiinMapper.class);
        List<UaFt200FindShikibetsuTaishoEntity> resultList = mapper.get宛名識別対象PSM(parameter);

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
            IShikibetsuTaisho 宛名識別対象 = 識別対象Finder.get識別対象(GyomuCode.DB介護保険,
                    宛名識別対象Entity.getShikibetsuCode(), KensakuYusenKubun.住登外優先);
            if (識別コード.equals(宛名識別対象Entity.getShikibetsuCode())) {
                IShikibetsuTaisho 識別対象 = 宛名識別対象;
                RString 本人区分 = new RString("1");
                setaiinJoho = new SetaiinJoho(識別対象, 本人区分);
            } else {
                IShikibetsuTaisho 識別対象 = 宛名識別対象;
                RString 本人区分 = new RString("2");
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

    /**
     * 世帯員識別コード取得
     *
     * @param 識別コード 識別コード
     * @param 基準年月日 基準年月日
     * @return 世帯員識別コードリスト
     */
    public List<SetaiinShikibetsuCd> get世帯員識別コード(ShikibetsuCode 識別コード, FlexibleDate 基準年月日) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(基準年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("基準年月日"));

        List<SetaiinShikibetsuCd> 世帯員識別コードリスト = new ArrayList<>();
        HihokenshaDaichoManager hihokenshaDaichoManager = new HihokenshaDaichoManager();
        HihokenshaDaicho 被保台帳 = hihokenshaDaichoManager.find被保険者台帳(識別コード, 基準年月日);

        if (null != 被保台帳) {
            if (new RString("1").equals(被保台帳.get住所地特例フラグ())) {
                SetaiCode 世帯コード = null;
                ShikibetsuCode 世帯員識別コード = 被保台帳.get識別コード();
                RString 本人区分 = new RString("1");
                SetaiinShikibetsuCd 世帯員識別コードの管理 = new SetaiinShikibetsuCd(世帯コード, 世帯員識別コード, 本人区分);
                世帯員識別コードリスト.add(世帯員識別コードの管理);
            }
            if (!new RString("1").equals(被保台帳.get住所地特例フラグ()) || 世帯員識別コードリスト.isEmpty()) {
                世帯員識別コードリスト = search世帯員(識別コード, 基準年月日, 世帯員識別コードリスト);
            }
        }
        return 世帯員識別コードリスト;
    }

    /**
     * 世帯員情報取得
     *
     * @param 世帯員識別コードリスト 世帯員識別コードリスト
     * @param 基準年月日 基準年月日
     * @return 世帯員情報リスト
     */
    public List<SetaiinJoho> get世帯員情報(List<SetaiinShikibetsuCd> 世帯員識別コードリスト, FlexibleDate 基準年月日) {
        requireNonNull(世帯員識別コードリスト, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯員識別コードリスト"));
        requireNonNull(基準年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("基準年月日"));

        SetaiinJoho setaiinJoho;
        List<SetaiinJoho> 世帯員情報リスト = new ArrayList<>();
        for (SetaiinShikibetsuCd 世帯員識別コード : 世帯員識別コードリスト) {
            ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険,
                    KensakuYusenKubun.住登外優先);
            builder.set識別コード(世帯員識別コード.get世帯員識別コード());
            IShikibetsuTaishoPSMSearchKey searchKey = builder.build();
            SetaiinParameter parameter = new SetaiinParameter(searchKey);
            ISetaiinMapper mapper = mapperProvider.create(ISetaiinMapper.class);
            List<UaFt200FindShikibetsuTaishoEntity> resultList = mapper.get宛名識別対象PSM(parameter);

            for (UaFt200FindShikibetsuTaishoEntity 宛名識別対象Entity : resultList) {
                IShikibetsuTaishoFinder 識別対象Finder = ShikibetsuTaishoService.getShikibetsuTaishoFinder();
                IShikibetsuTaisho 宛名識別対象 = 識別対象Finder.get識別対象(GyomuCode.DB介護保険,
                        宛名識別対象Entity.getShikibetsuCode(), KensakuYusenKubun.住登外優先);
                // TODO QA:552
                if (世帯員識別コード.get世帯員識別コード().equals(宛名識別対象Entity.getShikibetsuCode())) {
                    IShikibetsuTaisho 識別対象 = 宛名識別対象;
                    RString 本人区分 = new RString("1");
                    setaiinJoho = new SetaiinJoho(識別対象, 本人区分);
                } else {
                    IShikibetsuTaisho 識別対象 = 宛名識別対象;
                    RString 本人区分 = new RString("2");
                    setaiinJoho = new SetaiinJoho(識別対象, 本人区分);
                }
                世帯員情報リスト.add(setaiinJoho);
            }

        }
        return 世帯員情報リスト;
    }

    private List<SetaiinShikibetsuCd> search世帯員(ShikibetsuCode 識別コード,
            FlexibleDate 基準年月日, List<SetaiinShikibetsuCd> 世帯員識別コードリスト) {

        IKojins 世帯員リスト;
        RString 本人区分;
        ISetaiFinder finder = ShikibetsuTaishoService.getSetaiFinder();
        ISetai isetai = finder.findBy識別コード(GyomuCode.DB介護保険, 識別コード, 基準年月日);

        if (isetai == null) {
            return 世帯員識別コードリスト;
        } else {
            世帯員リスト = isetai.get世帯員リスト();
        }
        SetaiCode 世帯コード = isetai.getSetaiCode();
        for (IKojin iKojin : 世帯員リスト) {
            ShikibetsuCode 世帯員識別コード = iKojin.get識別コード();
            if (識別コード.equals(iKojin.get識別コード())) {
                本人区分 = new RString("1");
            } else {
                本人区分 = new RString("2");
            }
            SetaiinShikibetsuCd 世帯員識別コードの管理 = new SetaiinShikibetsuCd(世帯コード, 世帯員識別コード, 本人区分);
            世帯員識別コードリスト.add(世帯員識別コードの管理);
        }
        return 世帯員識別コードリスト;
    }
}
