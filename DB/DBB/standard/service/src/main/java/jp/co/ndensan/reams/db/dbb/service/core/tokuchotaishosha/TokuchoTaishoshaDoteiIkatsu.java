/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.tokuchotaishosha;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchotaishoshadotei.DoteiIchijiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchotaishoshadotei.TokuchoTaishoshaDoteiCombineEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2001ChoshuHohoDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchotaishoshadotei.ITokuchoTaishoshaDoteiMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakukubun.ShikakuKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.ue.uex.definition.core.DoteiFuitchiRiyu;
import jp.co.ndensan.reams.ue.uex.definition.core.TokubetsuChoshuGimushaCode;
import jp.co.ndensan.reams.ue.uex.definition.core.TokubetsuChoshuGimushaGroupCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBBBZ81002_2_特徴対象者同定（一括）（バッチ）
 *
 * @reamsid_L DBB-1850-050 zhangrui
 *
 */
public class TokuchoTaishoshaDoteiIkatsu {

    private final MapperProvider mapperProvider;
    private final DbT2001ChoshuHohoDac db2001Dac;
    private final DbT7022ShoriDateKanriDac db7022Dac;

    private static final RString 徴収方法_1月 = new RString("01");
    private static final RString 徴収方法_2月 = new RString("02");
    private static final RString 徴収方法_3月 = new RString("03");
    private static final RString 徴収方法_4月 = new RString("04");
    private static final RString 徴収方法_5月 = new RString("05");
    private static final RString 徴収方法_6月 = new RString("06");
    private static final RString 徴収方法_7月 = new RString("07");
    private static final RString 徴収方法_8月 = new RString("08");
    private static final RString 徴収方法_9月 = new RString("09");
    private static final RString 徴収方法_10月 = new RString("10");
    private static final RString 徴収方法_11月 = new RString("11");
    private static final RString 徴収方法_12月 = new RString("12");

    private static final RString 開始月_02 = new RString("02");
    private static final RString 開始月_04 = new RString("04");
    private static final RString 開始月_06 = new RString("06");
    private static final RString 開始月_08 = new RString("08");
    private static final RString 開始月_10 = new RString("10");
    private static final RString 開始月_12 = new RString("12");

    private static final RString 年度内連番_0001 = new RString("0001");
    private static final RString 年度内連番_0002 = new RString("0002");
    private static final RString 年度内連番_0003 = new RString("0003");
    private static final RString 年度内連番_0004 = new RString("0004");
    private static final RString 年度内連番_0005 = new RString("0005");
    private static final RString 年度内連番_0006 = new RString("0006");

    private static final RString 徴収種類_仮徴収 = new RString("仮徴収");
    private static final RString 徴収種類_本徴収 = new RString("本徴収");
    private static final RString 徴収種類_翌年度仮徴収 = new RString("翌年度仮徴収");

    private static final RString 地方公務員共済組合連合会 = new RString("001");
    private static final RString FIELD_SHIKIBETSUCODE = new RString("shikibetsuCode");
    private static final RString FIELD_FUITCHIRIYUCODE = new RString("fuitchiRiyuCode");

    /**
     * コンストラクタです。
     */
    public TokuchoTaishoshaDoteiIkatsu() {
        this.db7022Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        this.db2001Dac = InstanceProvider.create(DbT2001ChoshuHohoDac.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TokuchoTaishoshaDoteiIkatsu}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TokuchoTaishoshaDoteiIkatsu}のインスタンス
     */
    public static TokuchoTaishoshaDoteiIkatsu createInstance() {
        return InstanceProvider.create(TokuchoTaishoshaDoteiIkatsu.class);
    }

    /**
     * 業務被保険者情報作成（年次）
     *
     */
    public void createGyomuHokenshaJohoNenji() {
        FlexibleDate now = FlexibleDate.getNowDate();
        ITokuchoTaishoshaDoteiMapper mapper = mapperProvider.create(ITokuchoTaishoshaDoteiMapper.class);
        List<TokuchoTaishoshaDoteiCombineEntity> 全件List = mapper.get介護の３つのテーブルの全件();
        if (null != 全件List && !全件List.isEmpty()) {
            for (TokuchoTaishoshaDoteiCombineEntity entity : 全件List) {
                Entry<ShikibetsuCode, DoteiFuitchiRiyu> entry = get不一致理由_年次(entity, now);
                if (null != entry.getValue()) {
                    Map<String, RString> map = new HashMap<>();
                    map.put(FIELD_SHIKIBETSUCODE.toString(), entry.getKey().getColumnValue());
                    map.put(FIELD_FUITCHIRIYUCODE.toString(), entry.getValue().getコード());
                    mapper.insert業務被保険者情報一時テーブル(map);
                }
            }
        }
    }

    /**
     * 業務被保険者情報作成（月次）
     *
     * @param 処理年度 FlexibleYear
     * @param 開始月 List<RString>
     */
    public void createGyomuHokenshaJohoGetsuji(FlexibleYear 処理年度, RString 開始月) {
        FlexibleDate now = FlexibleDate.getNowDate();
        ITokuchoTaishoshaDoteiMapper mapper = mapperProvider.create(ITokuchoTaishoshaDoteiMapper.class);
        List<TokuchoTaishoshaDoteiCombineEntity> 全件List = mapper.get介護の３つのテーブルと徴収方法の全件(処理年度);
        if (null != 全件List && !全件List.isEmpty()) {
            for (TokuchoTaishoshaDoteiCombineEntity entity : 全件List) {
                Entry<ShikibetsuCode, DoteiFuitchiRiyu> entry = get不一致理由_月次(entity, now, 開始月);
                if (null != entry.getValue()) {
                    Map<String, RString> map = new HashMap<>();
                    map.put(FIELD_SHIKIBETSUCODE.toString(), entry.getKey().getColumnValue());
                    map.put(FIELD_FUITCHIRIYUCODE.toString(), entry.getValue().getコード());
                    mapper.insert業務被保険者情報一時テーブル(map);
                }
            }
        }
    }

    /**
     * 徴収方法情報作成
     *
     * @param 処理年度 FlexibleYear
     * @param 開始月 開始月
     * @param 処理日時 処理日時
     */
    public void createChoshuHohoJoho(FlexibleYear 処理年度, RString 開始月, RDateTime 処理日時) {
        ITokuchoTaishoshaDoteiMapper mapper = mapperProvider.create(ITokuchoTaishoshaDoteiMapper.class);
        List<TokuchoTaishoshaDoteiCombineEntity> 全件List = mapper.get徴収方法情報(処理年度);
        RString 徴収種類 = get徴収種類(開始月);
        for (TokuchoTaishoshaDoteiCombineEntity entity : 全件List) {
            ChoshuHoho 徴収方法 = get徴収方法(mapper, entity.getDoteitemp());
            DbV2001ChoshuHohoEntity 最新徴収方法Entity = build介護徴収方法(entity.getChoshuhoho(), entity.getDoteitemp(),
                    徴収種類, 徴収方法.getコード(), 開始月);
            最新徴収方法Entity.setRirekiNo(最新徴収方法Entity.getRirekiNo() + 1);
            最新徴収方法Entity.setIraiSohuzumiFlag(false);
            最新徴収方法Entity.setTsuikaIraiSohuzumiFlag(false);
            最新徴収方法Entity.setTokuchoTeishiNichiji(null);
            最新徴収方法Entity.setTokuchoTeishiJiyuCode(null);
            DbT2001ChoshuHohoEntity 徴収方法Entity = transDbV2001ToDbT2001(最新徴収方法Entity);
            徴収方法Entity.setState(EntityDataState.Added);
            if (null != 徴収方法Entity.getFukaNendo()) {
                db2001Dac.save(徴収方法Entity);
            }
        }
        RString 年度内連番 = RString.EMPTY;
        if (開始月_08.equals(開始月)) {
            年度内連番 = 年度内連番_0001;
        } else if (開始月_10.equals(開始月)) {
            年度内連番 = 年度内連番_0002;
        } else if (開始月_12.equals(開始月)) {
            年度内連番 = 年度内連番_0003;
        } else if (開始月_02.equals(開始月)) {
            年度内連番 = 年度内連番_0004;
        } else if (開始月_04.equals(開始月)) {
            年度内連番 = 年度内連番_0005;
        } else if (開始月_06.equals(開始月)) {
            年度内連番 = 年度内連番_0006;
        }
        List<DbT7022ShoriDateKanriEntity> 日付List = db7022Dac.selectFor依頼金額計算基準日取得(SubGyomuCode.DBB介護賦課,
                ShoriName.特徴対象者同定.get名称(), 処理年度, 年度内連番);
        for (DbT7022ShoriDateKanriEntity entity : 日付List) {
            entity.setKijunTimestamp(new YMDHMS(処理日時));
            entity.setState(EntityDataState.Modified);
            db7022Dac.save(entity);
        }
    }

    /**
     * 特徴未同定情報作成
     *
     * @param 開始月 RString
     * @param 処理日時 RDateTime
     */
    public void createTkMidoteiJoho(RString 開始月, RDateTime 処理日時) {
        ITokuchoTaishoshaDoteiMapper mapper = mapperProvider.create(ITokuchoTaishoshaDoteiMapper.class);
        mapper.do特徴未同定情報作成(開始月);
    }

    private Entry<ShikibetsuCode, DoteiFuitchiRiyu> get不一致理由_年次(TokuchoTaishoshaDoteiCombineEntity entity,
            FlexibleDate now) {
        DoteiFuitchiRiyu 不一致理由 = null;
        if (null != entity.getHihokensha() && null != entity.getHihokensha().getShikibetsuCode()) {
            boolean 資格喪失flag = do資格喪失の判定(entity.getHihokensha(), now);
            if (資格喪失flag) {
                不一致理由 = do他市町村住所地特例者台帳時不一致理由(entity.getTokurei(), entity.getJogaisha(), true);
            }
        } else {
            不一致理由 = do他市町村住所地特例者台帳時不一致理由(entity.getTokurei(), entity.getJogaisha(), false);
        }
        if (null != entity.getHihokensha() && null != entity.getHihokensha().getShikibetsuCode()) {
            return new SimpleEntry(entity.getHihokensha().getShikibetsuCode(), 不一致理由);
        } else if (null != entity.getTokurei() && null != entity.getTokurei().getShikibetsuCode()) {
            return new SimpleEntry(entity.getTokurei().getShikibetsuCode(), 不一致理由);
        } else {
            return new SimpleEntry(entity.getJogaisha().getShikibetsuCode(), 不一致理由);
        }

    }

    private boolean do資格喪失の判定(DbV1001HihokenshaDaichoEntity 被保険者, FlexibleDate now) {
        return !(ShikakuKubun._１号.getコード().equals(被保険者.getHihokennshaKubunCode())
                && 被保険者.getIchigoShikakuShutokuYMD().compareTo(now) <= 0
                && (null == 被保険者.getShikakuSoshitsuYMD() || FlexibleDate.EMPTY.equals(被保険者.getShikakuSoshitsuYMD())
                || now.compareTo(被保険者.getShikakuSoshitsuYMD()) <= 0) && !被保険者.getLogicalDeletedFlag());
    }

    private DoteiFuitchiRiyu do他市町村住所地特例者台帳時不一致理由(DbV1003TashichosonJushochiTokureiEntity tokurei,
            DbV1002TekiyoJogaishaEntity jogaisha, boolean 被保険者台帳があるFlag) {
        //TODO QA882 「UEX_Enum．同定不一致理由．資格なし_他特例者」と「UEX_Enum．同定不一致理由．資格なし_適用除外者」
        //が実装していませんので、コーディングできません、同じEnumを利用しています
        if (null != tokurei && null != tokurei.getShikibetsuCode()) {
            FlexibleDate 解除年月日 = tokurei.getKaijoYMD();
            return (null == 解除年月日 || 解除年月日.equals(FlexibleDate.EMPTY))
                    ? DoteiFuitchiRiyu.その他 : DoteiFuitchiRiyu.資格なし;
        } else if (null != jogaisha && null != jogaisha.getShikibetsuCode()) {
            FlexibleDate 解除年月日 = jogaisha.getKaijoYMD();
            return (null == 解除年月日 || 解除年月日.equals(FlexibleDate.EMPTY))
                    ? DoteiFuitchiRiyu.その他 : DoteiFuitchiRiyu.資格なし;
        } else if (被保険者台帳があるFlag) {
            return DoteiFuitchiRiyu.資格喪失;
        }
        return null;
    }

    private Entry<ShikibetsuCode, DoteiFuitchiRiyu> get不一致理由_月次(TokuchoTaishoshaDoteiCombineEntity entity,
            FlexibleDate now, RString 開始月) {
        DoteiFuitchiRiyu 不一致理由;
        if (null != entity.getHihokensha() && null != entity.getHihokensha().getShikibetsuCode()) {
            boolean 資格喪失flag = do資格喪失の判定(entity.getHihokensha(), now);
            if (!資格喪失flag) {
                不一致理由 = do徴収方法の不一致理由(entity.getChoshuhoho(), 開始月);
            } else {
                不一致理由 = do他市町村住所地特例者台帳時不一致理由(entity.getTokurei(), entity.getJogaisha(), true);
            }
        } else {
            不一致理由 = do他市町村住所地特例者台帳時不一致理由(entity.getTokurei(), entity.getJogaisha(), false);
        }
        if (null != entity.getHihokensha() && null != entity.getHihokensha().getShikibetsuCode()) {
            return new SimpleEntry(entity.getHihokensha().getShikibetsuCode(), 不一致理由);
        } else if (null != entity.getTokurei() && null != entity.getTokurei().getShikibetsuCode()) {
            return new SimpleEntry(entity.getTokurei().getShikibetsuCode(), 不一致理由);
        } else {
            return new SimpleEntry(entity.getJogaisha().getShikibetsuCode(), 不一致理由);
        }
    }

    private DoteiFuitchiRiyu do徴収方法の不一致理由(DbV2001ChoshuHohoEntity 徴収方法, RString 開始月) {
        if (null != 徴収方法) {
            RString 徴収方法X月 = get徴収方法X月(徴収方法, 開始月);
            if (ChoshuHoho.特別徴収_厚生労働省.getコード().equals(徴収方法X月)
                    || ChoshuHoho.特別徴収_地共済.getコード().equals(徴収方法X月)) {
                return DoteiFuitchiRiyu.特徴対象者登録済;
            }
        }
        return null;
    }

    private RString get徴収方法X月(DbV2001ChoshuHohoEntity 徴収方法, RString 開始月) {
        if (RString.isNullOrEmpty(開始月)) {
            return RString.EMPTY;
        }
        if (徴収方法_1月.equals(開始月)) {
            return 徴収方法.getChoshuHoho1gatsu();
        }
        if (徴収方法_2月.equals(開始月)) {
            return 徴収方法.getChoshuHoho2gatsu();
        }
        if (徴収方法_3月.equals(開始月)) {
            return 徴収方法.getChoshuHoho3gatsu();
        }
        if (徴収方法_4月.equals(開始月)) {
            return 徴収方法.getChoshuHoho4gatsu();
        }
        if (徴収方法_5月.equals(開始月)) {
            return 徴収方法.getChoshuHoho5gatsu();
        }
        if (徴収方法_6月.equals(開始月)) {
            return 徴収方法.getChoshuHoho6gatsu();
        }
        if (徴収方法_7月.equals(開始月)) {
            return 徴収方法.getChoshuHoho7gatsu();
        }
        if (徴収方法_8月.equals(開始月)) {
            return 徴収方法.getChoshuHoho8gatsu();
        }
        if (徴収方法_9月.equals(開始月)) {
            return 徴収方法.getChoshuHoho9gatsu();
        }
        if (徴収方法_10月.equals(開始月)) {
            return 徴収方法.getChoshuHoho10gatsu();
        }
        if (徴収方法_11月.equals(開始月)) {
            return 徴収方法.getChoshuHoho11gatsu();
        }
        if (徴収方法_12月.equals(開始月)) {
            return 徴収方法.getChoshuHoho12gatsu();
        }
        return RString.EMPTY;
    }

    private RString get徴収種類(RString 開始月) {
        if (開始月_08.equals(開始月)) {
            return 徴収種類_仮徴収;
        } else if (開始月_10.equals(開始月) || 開始月_12.equals(開始月) || 開始月_02.equals(開始月)) {
            return 徴収種類_本徴収;
        } else if (開始月_04.equals(開始月) || 開始月_06.equals(開始月)) {
            return 徴収種類_翌年度仮徴収;
        }
        return RString.EMPTY;
    }

    private ChoshuHoho get徴収方法(ITokuchoTaishoshaDoteiMapper mapper, DoteiIchijiEntity 同定情報) {
        List<TokubetsuChoshuGimushaCode> 特別徴収義務者コードList = mapper.get特別徴収義務者コード(
                new TokubetsuChoshuGimushaGroupCode(地方公務員共済組合連合会));
        if (null != 特別徴収義務者コードList && !特別徴収義務者コードList.isEmpty()) {
            for (TokubetsuChoshuGimushaCode code : 特別徴収義務者コードList) {
                if (null != code && code.toRString().equals(同定情報.getDtTokubetsuChoshuGimushaCode())) {
                    return ChoshuHoho.特別徴収_地共済;
                }
            }
        }
        return ChoshuHoho.特別徴収_厚生労働省;

    }

    private DbV2001ChoshuHohoEntity build介護徴収方法(DbV2001ChoshuHohoEntity 徴収方法Entity,
            DoteiIchijiEntity 同定情報temp, RString 徴収種類, RString 徴収方法, RString 開始月) {
        if (徴収種類_仮徴収.equals(徴収種類)) {
            徴収方法Entity.setChoshuHoho8gatsu(徴収方法);
            徴収方法Entity.setChoshuHoho9gatsu(徴収方法);
            徴収方法Entity.setKariNenkinNo(同定情報temp.getDtKisoNenkinNo());
            徴収方法Entity.setKariNenkinCode(同定情報temp.getDtNenkinCode());
            徴収方法Entity.setKariHosokuM(同定情報temp.getHosokuTsuki());
        } else if (徴収種類_本徴収.equals(徴収種類)) {
            if (開始月_10.equals(開始月)) {
                徴収方法Entity.setChoshuHoho10gatsu(徴収方法);
                徴収方法Entity.setChoshuHoho11gatsu(徴収方法);
            }
            if (開始月_10.equals(開始月) || 開始月_12.equals(開始月)) {
                徴収方法Entity.setChoshuHoho12gatsu(徴収方法);
                徴収方法Entity.setChoshuHoho1gatsu(徴収方法);
            }
            徴収方法Entity.setChoshuHoho2gatsu(徴収方法);
            徴収方法Entity.setChoshuHoho3gatsu(徴収方法);
            徴収方法Entity.setChoshuHohoYoku4gatsu(徴収方法);
            徴収方法Entity.setChoshuHohoYoku5gatsu(徴収方法);
            徴収方法Entity.setChoshuHohoYoku6gatsu(徴収方法);
            徴収方法Entity.setChoshuHohoYoku7gatsu(徴収方法);
            徴収方法Entity.setChoshuHohoYoku8gatsu(徴収方法);
            徴収方法Entity.setChoshuHohoYoku9gatsu(徴収方法);
            徴収方法Entity.setHonNenkinNo(同定情報temp.getDtKisoNenkinNo());
            徴収方法Entity.setHonNenkinCode(同定情報temp.getDtNenkinCode());
            徴収方法Entity.setHonHosokuM(同定情報temp.getHosokuTsuki());
        } else if (徴収種類_翌年度仮徴収.equals(徴収種類)) {
            if (開始月_04.equals(開始月)) {
                徴収方法Entity.setChoshuHoho4gatsu(徴収方法);
                徴収方法Entity.setChoshuHoho5gatsu(徴収方法);
            }
            徴収方法Entity.setChoshuHoho6gatsu(徴収方法);
            徴収方法Entity.setChoshuHoho7gatsu(徴収方法);
            徴収方法Entity.setChoshuHoho8gatsu(徴収方法);
            徴収方法Entity.setChoshuHoho9gatsu(徴収方法);
            徴収方法Entity.setChoshuHoho10gatsu(徴収方法);
            徴収方法Entity.setChoshuHoho11gatsu(徴収方法);
            徴収方法Entity.setChoshuHoho12gatsu(徴収方法);
            徴収方法Entity.setChoshuHoho1gatsu(徴収方法);
            徴収方法Entity.setChoshuHoho2gatsu(徴収方法);
            徴収方法Entity.setChoshuHoho3gatsu(徴収方法);
            徴収方法Entity.setChoshuHohoYoku4gatsu(徴収方法);
            徴収方法Entity.setChoshuHohoYoku5gatsu(徴収方法);
            徴収方法Entity.setChoshuHohoYoku6gatsu(徴収方法);
            徴収方法Entity.setChoshuHohoYoku7gatsu(徴収方法);
            徴収方法Entity.setChoshuHohoYoku8gatsu(徴収方法);
            徴収方法Entity.setChoshuHohoYoku9gatsu(徴収方法);
            徴収方法Entity.setYokunendoKariNenkinNo(同定情報temp.getDtKisoNenkinNo());
            徴収方法Entity.setYokunendoKariNenkinCode(同定情報temp.getDtNenkinCode());
            徴収方法Entity.setYokunendoKariHosokuM(同定情報temp.getHosokuTsuki());
        }
        return 徴収方法Entity;
    }

    private DbT2001ChoshuHohoEntity transDbV2001ToDbT2001(DbV2001ChoshuHohoEntity 徴収方法Entity) {
        DbT2001ChoshuHohoEntity trans = new DbT2001ChoshuHohoEntity();
        trans.setChoshuHoho10gatsu(徴収方法Entity.getChoshuHoho10gatsu());
        trans.setChoshuHoho11gatsu(徴収方法Entity.getChoshuHoho11gatsu());
        trans.setChoshuHoho12gatsu(徴収方法Entity.getChoshuHoho12gatsu());
        trans.setChoshuHoho1gatsu(徴収方法Entity.getChoshuHoho1gatsu());
        trans.setChoshuHoho2gatsu(徴収方法Entity.getChoshuHoho2gatsu());
        trans.setChoshuHoho3gatsu(徴収方法Entity.getChoshuHoho3gatsu());
        trans.setChoshuHoho4gatsu(徴収方法Entity.getChoshuHoho4gatsu());
        trans.setChoshuHoho5gatsu(徴収方法Entity.getChoshuHoho5gatsu());
        trans.setChoshuHoho6gatsu(徴収方法Entity.getChoshuHoho6gatsu());
        trans.setChoshuHoho7gatsu(徴収方法Entity.getChoshuHoho7gatsu());
        trans.setChoshuHoho8gatsu(徴収方法Entity.getChoshuHoho8gatsu());
        trans.setChoshuHoho9gatsu(徴収方法Entity.getChoshuHoho9gatsu());
        trans.setChoshuHohoYoku4gatsu(徴収方法Entity.getChoshuHohoYoku4gatsu());
        trans.setChoshuHohoYoku5gatsu(徴収方法Entity.getChoshuHohoYoku5gatsu());
        trans.setChoshuHohoYoku6gatsu(徴収方法Entity.getChoshuHohoYoku6gatsu());
        trans.setChoshuHohoYoku7gatsu(徴収方法Entity.getChoshuHohoYoku7gatsu());
        trans.setChoshuHohoYoku8gatsu(徴収方法Entity.getChoshuHohoYoku8gatsu());
        trans.setChoshuHohoYoku9gatsu(徴収方法Entity.getChoshuHohoYoku9gatsu());
        FlexibleYear year = 徴収方法Entity.getFukaNendo();
        if (null != year) {
            trans.setFukaNendo(year);
        }
        HihokenshaNo hihokenshaNo = 徴収方法Entity.getHihokenshaNo();
        if (null != hihokenshaNo) {
            trans.setHihokenshaNo(hihokenshaNo);
        }
        trans.setHonHosokuM(徴収方法Entity.getHonHosokuM());
        trans.setHonNenkinCode(徴収方法Entity.getHonNenkinCode());
        trans.setHonNenkinNo(徴収方法Entity.getHonNenkinNo());
        trans.setInsertDantaiCd(徴収方法Entity.getInsertDantaiCd());
        trans.setIraiSohuzumiFlag(徴収方法Entity.getIraiSohuzumiFlag());
        trans.setIsDeleted(徴収方法Entity.getIsDeleted());
        trans.setKariHosokuM(徴収方法Entity.getKariHosokuM());
        trans.setKariNenkinCode(徴収方法Entity.getKariNenkinCode());
        trans.setKariNenkinNo(徴収方法Entity.getKariNenkinNo());
        trans.setRirekiNo(徴収方法Entity.getRirekiNo());
        trans.setTokuchoTeishiJiyuCode(徴収方法Entity.getTokuchoTeishiJiyuCode());
        trans.setTokuchoTeishiNichiji(徴収方法Entity.getTokuchoTeishiNichiji());
        trans.setTsuikaIraiSohuzumiFlag(徴収方法Entity.getTsuikaIraiSohuzumiFlag());
        trans.setYokunendoKariHosokuM(徴収方法Entity.getYokunendoKariHosokuM());
        trans.setYokunendoKariNenkinCode(徴収方法Entity.getYokunendoKariNenkinCode());
        trans.setYokunendoKariNenkinNo(徴収方法Entity.getYokunendoKariNenkinNo());
        return trans;
    }

}
