/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.houshold;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.houshold.HousholdBusiness;
import jp.co.ndensan.reams.db.dbd.definition.core.hikazeinenkin.TorokuKubun;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.houshold.HousholdParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.houshold.HousholdUpdateParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.houshold.HousholdEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4037HikazeNenkinTaishoshaDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.houshold.IHousholdMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbV1001HihokenshaDaichoAliveDac;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 非課税年金対象者情報登録のデータアクセスクラスです。
 *
 * @reamsid_L DBD-4930-040 wangjie2
 */
public class HousholdFinder {

    private final MapperProvider mapperProvider;
    private final RString 処理枝番_2 = new RString("2");
    private final RString 処理枝番_3 = new RString("3");
    private final RString 月の前1桁_0 = new RString("0");
    private final RString 年次処理 = new RString("11");
    private final RString 月次処理 = new RString("12");
    private final RString データレコード = new RString("2");
    private final RString 補足給付初回回付_年次_情報 = new RString("93");
    private final RString 補足給付初回回付_月次_情報 = new RString("94");
    private final RString 処理結果_00 = new RString("00");
    private static final int 桁_3 = 3;
    private static final int 桁_4 = 4;
    private static final int 桁_10 = 10;

    /**
     * コンストラクタです。
     */
    HousholdFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * FinderのIntanceを作成します。
     *
     * @return HousholdFinder
     */
    public static HousholdFinder createIntance() {
        return InstanceProvider.create(HousholdFinder.class);
    }

    /**
     * 引数により、非課税年金検索する。
     *
     * @param 年度 年度
     * @param 被保険者番号 被保険者番号
     * @param 対象年 対象年
     * @param 年金保険者コード 年金保険者コード
     * @param 基礎年金番号 基礎年金番号
     * @param 年金コード 年金コード
     * @return 非課税年金対象情報List
     */
    @Transaction
    public List<HousholdBusiness> getLastInputHousehold(FlexibleYear 年度, HihokenshaNo 被保険者番号,
            RString 対象年, RString 年金保険者コード, RString 基礎年金番号, RString 年金コード) {
        HousholdParameter para = new HousholdParameter(年度, 被保険者番号, 対象年, 年金保険者コード, 基礎年金番号, 年金コード);
        IHousholdMapper mapper = mapperProvider.create(IHousholdMapper.class);
        List<HousholdBusiness> 非課税年金対象情報BusinessList = new ArrayList<>();
        List<HousholdEntity> 非課税年金対象情報List = mapper.非課税年金対象情報取得(para);
        for (HousholdEntity 非課税年金対象情報 : 非課税年金対象情報List) {
            非課税年金対象情報BusinessList.add(new HousholdBusiness(非課税年金対象情報));
        }
        return 非課税年金対象情報BusinessList;
    }

    /**
     * 月DDL取得する。
     *
     * @param 年度 年度
     * @param 年次_Key 年次_Key
     * @return 月DDLKe
     */
    @Transaction
    public RString get月DDLKey(RString 年度, RString 年次_Key) {
        DbT7022ShoriDateKanriDac dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        List<RString> 処理枝番List = new ArrayList<>();
        処理枝番List.add(処理枝番_2);
        処理枝番List.add(処理枝番_3);
        List<DbT7022ShoriDateKanriEntity> entityList
                = dac.select年度内通番(SubGyomuCode.DBD介護受給, 年度, ShoriName.非課税年金対象者情報取込.get名称(), 処理枝番List);
        if (entityList.isEmpty()) {
            return 年次_Key;
        } else {
            return entityList.get(0).getNendoNaiRenban();
        }
    }

    /**
     * 重複チェックデータ取得する。
     *
     * @param 被保番号 被保番号
     * @param 年金保険者コード 年金保険者コード
     * @param 年金コードの先頭３桁 年金コードの先頭３桁
     * @param 現基礎年金番号 現基礎年金番号
     * @param 対象年 対象年
     * @param 作成年月日 作成年月日
     * @return 重複チェックデータ
     */
    @Transaction
    public int 重複チェック(RString 被保番号, RString 年金保険者コード,
            RString 年金コードの先頭３桁, RString 現基礎年金番号, RString 対象年, RString 作成年月日) {
        DbT4037HikazeNenkinTaishoshaDac dac = InstanceProvider.create(DbT4037HikazeNenkinTaishoshaDac.class);
        if (dac.select重複チェックデータ(被保番号, 年金保険者コード, 年金コードの先頭３桁, 現基礎年金番号, 対象年, 作成年月日).isEmpty()) {
            return 0;
        }
        return 1;
    }

    /**
     * 訂正区分また各種区分を取得します。
     *
     * @param 被保番号 被保番号
     * @param 年金保険者コード 年金保険者コード
     * @param 年金コード 年金コード
     * @param 基礎年金番号 基礎年金番号
     * @param 対象年 対象年
     * @return 区分
     */
    @Transaction
    public int select訂正区分また各種区分(RString 被保番号,
            RString 年金保険者コード, RString 年金コード, RString 基礎年金番号, RString 対象年) {
        DbT4037HikazeNenkinTaishoshaDac dac = InstanceProvider.create(DbT4037HikazeNenkinTaishoshaDac.class);
        if (dac.select訂正区分また各種区分(被保番号, 年金保険者コード, 年金コード, 基礎年金番号, 対象年).isEmpty()) {
            return 0;
        }
        return 1;
    }

    private void setキー(HousholdBusiness 非課税年金対象者一時, HousholdUpdateParameter parameter) {
        parameter.set基礎年金番号_キー(非課税年金対象者一時.get基礎年金番号());
        parameter.set年金コード_キー(非課税年金対象者一時.get年金コード());
        parameter.set被保番号_キー(非課税年金対象者一時.get被保険者番号());
        parameter.set年金保険者コード_キー(非課税年金対象者一時.get年金保険者());
        parameter.set作成年月日_キー(非課税年金対象者一時.get作成年月日());
        parameter.set対象年_キー(非課税年金対象者一時.get対象年());
    }

    /**
     * 「DB出力(非課税年金対象者)」の「編集仕様(UPDATE)」の「解除キー」を参照し、当該データを削除します。
     *
     * @param 非課税年金対象者一時 非課税年金対象者一時
     */
    @Transaction
    public void 削除解除_登録区分_画面登録_保存処理(HousholdBusiness 非課税年金対象者一時) {
        HousholdUpdateParameter parameter = new HousholdUpdateParameter();
        setキー(非課税年金対象者一時, parameter);
        IHousholdMapper mapper = mapperProvider.create(IHousholdMapper.class);
        mapper.削除解除_登録区分_画面登録_保存処理(parameter);
    }

    /**
     * 「DB出力(非課税年金対象者)」の「編集仕様(UPDATE)」の「更新条件検索キー」と「更新_取込」を参照し、DBに更新します。
     *
     * @param 非課税年金対象者一時 非課税年金対象者一時
     * @param 現基礎年金番号 現基礎年金番号
     * @param 被保番号 被保番号
     * @param userId userId
     */
    @Transaction
    public void 取込_保存処理(HousholdBusiness 非課税年金対象者一時, RString 現基礎年金番号, RString 被保番号, RString userId) {
        HousholdUpdateParameter parameter = new HousholdUpdateParameter();
        setキー(非課税年金対象者一時, parameter);
        if (null == 現基礎年金番号) {
            parameter.set現基礎年金番号(RString.EMPTY);
        } else {
            parameter.set現基礎年金番号(現基礎年金番号);
        }
        if (null == 被保番号) {
            parameter.set被保険者番号(RString.EMPTY);
        } else {
            parameter.set被保険者番号(被保番号);
        }
        IHousholdMapper mapper = mapperProvider.create(IHousholdMapper.class);
        mapper.取込_保存処理(parameter);
    }

    /**
     * 「DB出力(非課税年金対象者)」の「編集仕様(INSERT))」の「新規登録」を参照し、DBに追加します。
     *
     * @param 年度 年度
     * @param 月 月
     * @param 基礎年金番号 基礎年金番号
     * @param 現基礎年金番号 現基礎年金番号
     * @param 年金コード 年金コード
     * @param 被保番号 被保番号
     * @param 年金保険者コード 年金保険者コード
     * @param 性別 性別
     * @param 生年月日 生年月日
     * @param 作成年月日 作成年月日
     * @param 氏名カナ 氏名カナ
     * @param 氏名漢字 氏名漢字
     * @param 住所カナ 住所カナ
     * @param 住所漢字 住所漢字
     * @param 訂正区分 訂正区分
     * @param 対象年 対象年
     * @param 各種区分 各種区分
     * @param 金額 金額
     * @param userId userId
     */
    @Transaction
    public void 新規_保存処理(RString 年度, RString 月, RString 基礎年金番号, RString 現基礎年金番号, RString 年金コード,
            RString 被保番号, RString 年金保険者コード, RDate 作成年月日, RDate 生年月日, RString 性別, RString 氏名カナ,
            RString 氏名漢字, RString 住所カナ, RString 住所漢字, RString 対象年, RString 訂正区分, RString 各種区分, RString 金額, RString userId) {
        HousholdUpdateParameter parameter = new HousholdUpdateParameter();
        parameter.set年度(年度);
        parameter.set処理区分(get処理区分(月));
        parameter.set対象月(月.substring(1));
        parameter.set基礎年金番号(get左0埋めRString(基礎年金番号, 桁_10));
        parameter.set現基礎年金番号(get左0埋めRString(現基礎年金番号, 桁_10));
        parameter.set年金コード(get左0埋めRString(年金コード, 桁_4));
        parameter.set被保険者番号(被保番号);
        parameter.set登録区分(TorokuKubun.画面登録.getコード());
        parameter.setDtレコード区分(データレコード);
        parameter.setDt市町村コード(getDT市町村コード(被保番号));
        parameter.setDt年金保険者コード(get左0埋めRString(年金保険者コード, 桁_3));
        parameter.setDt通知内容コード(getDT通知内容コード(月));
        parameter.setDt作成年月日(作成年月日.toDateString());
        parameter.setDt基礎年金番号(get左0埋めRString(基礎年金番号, 桁_10));
        parameter.setDt年金コード(get左0埋めRString(年金コード, 桁_4));
        parameter.setDt生年月日(生年月日.toDateString());
        parameter.setDt性別(性別);
        parameter.setDtカナ氏名(氏名カナ);
        parameter.setDt漢字氏名(氏名漢字);
        parameter.setDtカナ住所(住所カナ);
        parameter.setDt漢字住所(住所漢字);
        parameter.setDt対象年(対象年);
        parameter.setDt訂正表示(訂正区分);
        parameter.setDt各種区分(各種区分);
        parameter.setDt処理結果(処理結果_00);
        parameter.setDt金額１(金額);
        IHousholdMapper mapper = mapperProvider.create(IHousholdMapper.class);
        mapper.新規_保存処理(parameter);
    }

    private RString getDT市町村コード(RString 被保番号) {
        DbV1001HihokenshaDaichoAliveDac dac = InstanceProvider.create(DbV1001HihokenshaDaichoAliveDac.class);
        DbV1001HihokenshaDaichoEntity entity = dac.get被保険者台帳(new HihokenshaNo(被保番号));
        if (null == entity || null == entity.getShichosonCode()) {
            return RString.EMPTY;
        }
        return entity.getShichosonCode().getColumnValue();
    }

    /**
     * 「DB出力(非課税年金対象者)」の「編集仕様(UPDATE)」の「更新条件検索キー」と「更新_画面登録」を参照し、DBに更新します。
     *
     * @param 非課税年金対象者一時 非課税年金対象者一時
     * @param 月 月
     * @param 現基礎年金番号 現基礎年金番号
     * @param 被保番号 被保番号
     * @param 性別 性別
     * @param 生年月日 生年月日
     * @param 作成年月日 作成年月日
     * @param 氏名カナ 氏名カナ
     * @param 氏名漢字 氏名漢字
     * @param 住所カナ 住所カナ
     * @param 住所漢字 住所漢字
     * @param 対象年 対象年
     * @param 金額 金額
     * @param userId userId
     */
    @Transaction
    public void 修正_登録区分_画面登録_保存処理(HousholdBusiness 非課税年金対象者一時, RString 月, RString 現基礎年金番号,
            RString 被保番号, RDate 作成年月日, RDate 生年月日, RString 性別, RString 氏名カナ,
            RString 氏名漢字, RString 住所カナ, RString 住所漢字, RString 対象年, RString 金額, RString userId) {
        HousholdUpdateParameter parameter = new HousholdUpdateParameter();
        setキー(非課税年金対象者一時, parameter);
        parameter.set処理区分(get処理区分(月));
        parameter.set対象月(月.substring(1));
        parameter.set現基礎年金番号(get左0埋めRString(現基礎年金番号, 桁_10));
        parameter.set被保険者番号(被保番号);
        parameter.setDt作成年月日(作成年月日.toDateString());
        parameter.setDt生年月日(生年月日.toDateString());
        parameter.setDt性別(性別);
        parameter.setDtカナ氏名(氏名カナ);
        parameter.setDt漢字氏名(氏名漢字);
        parameter.setDtカナ住所(住所カナ);
        parameter.setDt漢字住所(住所漢字);
        parameter.setDt対象年(対象年);
        parameter.setDt金額１(金額);
        IHousholdMapper mapper = mapperProvider.create(IHousholdMapper.class);
        mapper.修正_登録区分_画面登録_保存処理(parameter);
    }

    private RString get左0埋めRString(RString value, int 桁) {
        return value.padLeft("0", 桁);
    }

    private RString getDT通知内容コード(RString 月) {
        if (月の前1桁_0.equals(月.substring(0, 1))) {
            return 補足給付初回回付_年次_情報;
        }
        return 補足給付初回回付_月次_情報;
    }

    private RString get処理区分(RString 月) {
        if (月の前1桁_0.equals(月.substring(0, 1))) {
            return 年次処理;
        }
        return 月次処理;
    }

}
