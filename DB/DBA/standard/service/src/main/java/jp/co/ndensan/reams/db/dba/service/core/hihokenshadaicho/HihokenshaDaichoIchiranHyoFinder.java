/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.hihokenshadaicho;

import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.hihokenshadaichosakusei.HihokenshaDaichoSakusei;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaicho.HihokenshaDaichoIchiranHyoRelateEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.DateOfBirthFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.AgeArrivalDay;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 被保険者台帳一括作成バッチより、被保険者台帳一覧表帳票用DataEntityを作成します。
 *
 * @reamsid_L DBA-0510-040 duanzhanli
 *
 */
public class HihokenshaDaichoIchiranHyoFinder {

    private static final RString MARU = new RString("○");
    private static final RString 被保険者区分コード_1 = new RString("1");
    private static final RString 被保険者区分コード_2 = new RString("2");
    private static final RString 資格区分_1号 = new RString("１号");
    private static final RString 資格区分_2号 = new RString("２号");
    private static final int LENGTH_50 = 50;
    private static final int LENGTH_60 = 60;

    private final DbT1001HihokenshaDaichoDac 被保険者台帳管理Dac;

    /**
     * コンストラクタです。
     */
    public HihokenshaDaichoIchiranHyoFinder() {
        this.被保険者台帳管理Dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link HihokenshaDaichoIchiranHyoFinder}のインスタンスを返します。
     *
     * @return HihokenshaDaichoIchiranHyoFinder
     */
    public static HihokenshaDaichoIchiranHyoFinder createInstance() {
        return InstanceProvider.create(HihokenshaDaichoIchiranHyoFinder.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param 被保険者台帳管理Dac 被保険者台帳管理Dac
     */
    HihokenshaDaichoIchiranHyoFinder(DbT1001HihokenshaDaichoDac 被保険者台帳管理Dac) {
        this.被保険者台帳管理Dac = 被保険者台帳管理Dac;
    }

    /**
     * 被保険者台帳一覧表帳票用DataEntityを作成します。
     *
     * @param entity entity
     * @param uaFt200Entity uaFt200Entity
     * @param リストNO リストNO
     * @return HihokenshaDaichoIchiranHyoRelateEntity
     */
    @Transaction
    public HihokenshaDaichoIchiranHyoRelateEntity getChohyoIchiran(HihokenshaDaichoSakusei entity,
            UaFt200FindShikibetsuTaishoEntity uaFt200Entity, int リストNO) {
        HihokenshaDaichoIchiranHyoRelateEntity 被保険者台帳一覧表Entity = new HihokenshaDaichoIchiranHyoRelateEntity();
        if (uaFt200Entity != null) {
            IShikibetsuTaisho 識別対象 = ShikibetsuTaishoFactory.createKojin(uaFt200Entity);
            被保険者台帳一覧表Entity.set年齢(get年齢(entity, 識別対象));
            被保険者台帳一覧表Entity.set郵便番号(識別対象.to個人().get住所().get郵便番号());
            被保険者台帳一覧表Entity.set町域コード(get町域コード(uaFt200Entity.getChoikiCode()));
        }
        被保険者台帳一覧表Entity.set作成日付(RDate.getNowDate());
        被保険者台帳一覧表Entity.set市町村ID(entity.get市町村コード());
        被保険者台帳一覧表Entity.set市町村名称(entity.get市町村名称());
        被保険者台帳一覧表Entity.set被保険者番号(entity.get被保険者番号());
        被保険者台帳一覧表Entity.set氏名カナ(entity.get氏名カナ());
        被保険者台帳一覧表Entity.set氏名(entity.get氏名());
        被保険者台帳一覧表Entity.set性別(entity.get性別());
        被保険者台帳一覧表Entity.set生年月日(entity.get生年月日());
        被保険者台帳一覧表Entity.set行政区(get行政区(entity));
        被保険者台帳一覧表Entity.set住所(get住所(entity));
        被保険者台帳一覧表Entity.set識別コード(entity.get識別コード());
        被保険者台帳一覧表Entity.set世帯コード(entity.get世帯コード());
        被保険者台帳一覧表Entity.set状態区分(entity.get状態());
        被保険者台帳一覧表Entity.set資格区分(get資格区分(entity));
        被保険者台帳一覧表Entity.set生保(get生保(entity));
        被保険者台帳一覧表Entity.set老福(get老福(entity));
        被保険者台帳一覧表Entity.set備考(RString.EMPTY);
        被保険者台帳一覧表Entity.setリストNO(リストNO);
        被保険者台帳一覧表Entity.set地区１(get地区(entity.get地区コード1()));
        被保険者台帳一覧表Entity.set地区２(get地区(entity.get地区コード2()));
        被保険者台帳一覧表Entity.set地区３(get地区(entity.get地区コード3()));
        return 被保険者台帳一覧表Entity;
    }

    private RString get町域コード(ChoikiCode 町域コード) {
        if (町域コード != null) {
            return 町域コード.value();
        }
        return RString.EMPTY;

    }

    private RString get地区(ChikuCode 地区) {
        if (地区 != null) {
            return 地区.value();
        }
        return RString.EMPTY;

    }

    private RString get住所(HihokenshaDaichoSakusei entity) {
        RString 住所;
        RString jusho = entity.get住所();
        if (jusho != null && jusho.toString().length() >= LENGTH_60) {
            住所 = jusho.substring(0, LENGTH_60);
        } else {
            住所 = jusho;
        }
        return 住所;
    }

    private GyoseikuCode get行政区(HihokenshaDaichoSakusei entity) {
        GyoseikuCode 行政区;
        GyoseikuCode gyoseikuCode = entity.get行政区コード();
        if (gyoseikuCode != null && gyoseikuCode.value().length() >= LENGTH_50) {
            行政区 = new GyoseikuCode(gyoseikuCode.value().substring(0, LENGTH_50));
        } else {
            行政区 = gyoseikuCode;
        }
        return 行政区;
    }

    private RString get年齢(HihokenshaDaichoSakusei entity, IShikibetsuTaisho 識別対象) {
        RString seinengappiYMD = entity.get生年月日();
        FlexibleDate 生年月日;
        if (!RString.isNullOrEmpty(seinengappiYMD)) {
            生年月日 = new FlexibleDate(entity.get生年月日());
        } else {
            生年月日 = FlexibleDate.EMPTY;
        }
        JuminJotai 住民状態 = 識別対象.to個人().get住民状態();
        FlexibleDate 消除異動年月日;
        if (住民状態.equals(JuminJotai.死亡者)) {
            消除異動年月日 = 識別対象.to個人().get消除異動年月日();
        } else {
            消除異動年月日 = FlexibleDate.MAX;
        }
        AgeCalculator ageCalculator = new AgeCalculator(DateOfBirthFactory.createInstance(生年月日), 住民状態,
                消除異動年月日, AgeArrivalDay.当日, FlexibleDate.getNowDate());
        return ageCalculator.get年齢();
    }

    private RString get生保(HihokenshaDaichoSakusei entity) {
        List<RString> 受給開始日List = entity.get生活保護情報().get受給開始日();
        List<RString> 受給廃止日List = entity.get生活保護情報().get受給廃止日();
        RString 生保 = RString.EMPTY;
        if (受給開始日List != null && !受給開始日List.isEmpty()) {
            int index = 受給開始日List.size() - 1;
            if (受給廃止日List != null && !受給廃止日List.isEmpty() && RString.isNullOrEmpty(受給廃止日List.get(index))) {
                生保 = MARU;
            }
        }
        return 生保;
    }

    private RString get老福(HihokenshaDaichoSakusei entity) {
        List<RString> 受給開始日List = entity.get老齢福祉情報().get老齢福祉受給開始日();
        List<RString> 受給終了日List = entity.get老齢福祉情報().get老齢福祉受給終了日();
        RString 老福 = RString.EMPTY;
        if (受給開始日List != null && !受給開始日List.isEmpty()) {
            int index = 受給開始日List.size() - 1;
            if (受給終了日List != null && !受給終了日List.isEmpty() && RString.isNullOrEmpty(受給終了日List.get(index))) {
                老福 = MARU;
            }
        }
        return 老福;
    }

    private RString get資格区分(HihokenshaDaichoSakusei entity) {
        RString 資格区分 = RString.EMPTY;
        RString 被保険者区分コード = 被保険者台帳管理Dac.selectByHihokenshaNo(entity.get被保険者番号()).getHihokennshaKubunCode();
        if (被保険者区分コード_1.equals(被保険者区分コード)) {
            資格区分 = 資格区分_1号;
        } else if (被保険者区分コード_2.equals(被保険者区分コード)) {
            資格区分 = 資格区分_2号;
        }
        return 資格区分;
    }
}
