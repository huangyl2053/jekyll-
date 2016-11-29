/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.tankinyushokakudaigaitosha;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.tankinyushokakudaigaitosha.ChushutsuKubun;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.tankinyushokakudaigaitosha.GendogakuKanriKikansu;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.tankinyushokakudaigaitosha.TankiNyushoKakudaiGaitoshaMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.tankinyushokakudaigaitosha.TankiNyushoKakudaiGaitoshaProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.tankinyushokakudaigaitosha.TankiNyushoKakudaiGaitoshaRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.euc.tankinyushokakudaigaitosha.TankiNyushoKakudaiGaitoshaReibanAriEUCEntity;
import jp.co.ndensan.reams.db.dbc.entity.euc.tankinyushokakudaigaitosha.TankiNyushoKakudaiGaitoshaReibanNashiEUCEntity;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.ChokkinIdoJiyuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.JukyuShinseiJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.NinteiShienShinseiKubun;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.shikaku.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.MinashiCode;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.jusho.banchi.Banchi;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト_短期入所拡大該当者ビジネスのクラスです
 *
 * @reamsid_L DBC-3111-020 duanzhanli
 */
@Getter
@Setter
public class TankiNyushoKakudaiGaitosha {

    private final TankiNyushoKakudaiGaitoshaProcessParameter processParameter;
    private static final RString 文字1 = new RString("1");
    private List<PersonalData> personalDataList;

    /**
     * コンストラクタです。
     *
     * @param processParameter processParameter
     */
    public TankiNyushoKakudaiGaitosha(TankiNyushoKakudaiGaitoshaProcessParameter processParameter) {
        this.processParameter = processParameter;
        personalDataList = new ArrayList<>();
    }

    /**
     * TankiNyushoKakudaiGaitoshaReibanAriEUCEntityの設定クラスです。
     *
     * @param entity entity
     * @param 市町村名MasterMap 市町村名MasterMap
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     * @param association association
     * @param 導入団体情報 Association
     * @param 連番 連番
     * @return JigyoBunKogakuGassanShikyuKetteibanAriEUCEntity
     */
    public TankiNyushoKakudaiGaitoshaReibanAriEUCEntity set連番ありEUCEntity(TankiNyushoKakudaiGaitoshaRelateEntity entity,
            Map<RString, KoseiShichosonMaster> 市町村名MasterMap,
            ChohyoSeigyoKyotsu 帳票制御共通, Association association, Association 導入団体情報, int 連番) {
        TankiNyushoKakudaiGaitoshaReibanAriEUCEntity eucEntity = new TankiNyushoKakudaiGaitoshaReibanAriEUCEntity();
        UaFt200FindShikibetsuTaishoEntity 宛名Entity = entity.get宛名Entity();
        if (宛名Entity != null) {
            IShikibetsuTaisho iShikibetsuTaisho = ShikibetsuTaishoFactory.createKojin(宛名Entity);
            IKojin iKojin = iShikibetsuTaisho.to個人();
            personalDataList.add(toPersonalData(entity.get被保険者番号(), iKojin.get識別コード()));
            eucEntity.set連番(new RString(連番));
            eucEntity.set識別コード(iKojin.get識別コード());
            eucEntity.set住民種別(iKojin.get住民状態().住民状態略称());
            eucEntity.set氏名(iKojin.get名称().getName());
            eucEntity.set氏名カナ(iKojin.get名称().getKana());
            eucEntity.set生年月日(set日付編集(iKojin.get生年月日().toFlexibleDate()));
            eucEntity.set年齢(iKojin.get年齢算出().get年齢());
            eucEntity.set性別(iKojin.get性別().getName().getShortJapanese());
            eucEntity.set続柄コード(iKojin.get続柄コードリスト().toTsuzukigaraCode());
            eucEntity.set世帯コード(iKojin.get世帯コード());
            eucEntity.set世帯主名(iKojin.get世帯主名());
            eucEntity.set住所コード(iKojin.get住所().get町域コード().value());
            eucEntity.set郵便番号(iKojin.get住所().get郵便番号().getEditedYubinNo());
            eucEntity.set住所_番地_方書(JushoHenshu.editJusho(帳票制御共通, iKojin, 導入団体情報));
            eucEntity.set住所(iKojin.get住所().get住所());
            eucEntity.set番地(get番地(iKojin.get住所().get番地()));
            eucEntity.set方書(get方書(iKojin.get住所().get方書()));
            eucEntity.set行政区コード(iKojin.get行政区画().getGyoseiku().getコード());
            eucEntity.set行政区名(iKojin.get行政区画().getGyoseiku().get名称());
            eucEntity.set地区１(iKojin.get行政区画().getChiku1().getコード());
            eucEntity.set地区２(iKojin.get行政区画().getChiku2().getコード());
            eucEntity.set地区３(iKojin.get行政区画().getChiku3().getコード());
            eucEntity.set連絡先１(iKojin.get連絡先１());
            eucEntity.set連絡先２(iKojin.get連絡先２());
            eucEntity.set登録異動日(set日付編集(iKojin.get登録異動年月日()));
            eucEntity.set登録事由(iKojin.get登録事由());
            eucEntity.set登録届出日(set日付編集(iKojin.get登録届出年月日()));
            eucEntity.set住定異動日(set日付編集(iKojin.get住定異動年月日()));
            eucEntity.set住定事由(iKojin.get住定事由());
            eucEntity.set住定届出日(set日付編集(iKojin.get住定届出年月日()));
            eucEntity.set消除異動日(set日付編集(iKojin.get消除異動年月日()));
            eucEntity.set消除事由(iKojin.get消除事由());
            eucEntity.set消除届出日(set日付編集(iKojin.get消除届出年月日()));
            eucEntity.set転出入理由(RString.EMPTY);
            eucEntity.set前住所郵便番号(iKojin.get転入前().get郵便番号().getEditedYubinNo());
            eucEntity.set前住所_番地_方書(get住所_番地_方書(iKojin.get転入前().get住所(),
                    get番地(iKojin.get転入前().get番地()), get方書(iKojin.get転入前().get方書())));
            eucEntity.set前住所(iKojin.get転入前().get住所());
            eucEntity.set前住所番地(get番地(iKojin.get転入前().get番地()));
            eucEntity.set前住所方書(get方書(iKojin.get転入前().get方書()));
            eucEntity.set市町村コード(entity.get市町村コード());
        }
        if (市町村名MasterMap != null && !市町村名MasterMap.isEmpty()) {
            eucEntity.set市町村名(市町村名MasterMap.get(entity.get市町村コード()).get市町村名称());
        }
        eucEntity.set保険者コード(association.get地方公共団体コード().value());
        eucEntity.set保険者名(association.get市町村名());
        eucEntity.set空白(RString.HALF_SPACE);
        eucEntity.set被保険者番号(entity.get被保険者番号());
        eucEntity.set資格取得事由(getCodeNameByCode(DBACodeShubetsu.介護資格取得事由_被保険者.getCodeShubetsu(), entity.get資格取得事由コード()));
        eucEntity.set資格取得日(set日付編集(entity.get資格取得年月日()));
        eucEntity.set資格取得届出日(set日付編集(entity.get資格取得届出年月日()));
        eucEntity.set喪失事由(getCodeNameByCode(DBACodeShubetsu.介護資格喪失事由_被保険者.getCodeShubetsu(), entity.get資格喪失事由コード()));
        eucEntity.set資格喪失日(set日付編集(entity.get資格喪失年月日()));
        eucEntity.set資格喪失届日(set日付編集(entity.get資格喪失届出年月日()));
        eucEntity.set資格区分(HihokenshaKubunCode.toValue(entity.get被保険者区分コード()).get名称());
        if (文字1.equals(entity.get住所地特例フラグ())) {
            eucEntity.set住所地特例状態(new RString("住特"));
        }
        eucEntity.set資格_証記載保険者番号(get証記載保険者番号(entity, 市町村名MasterMap));
        eucEntity.set受給申請事由(get受給申請事由(entity));
        eucEntity.set受給申請日(set日付編集(entity.get受給申請年月日()));
        if (!isNullCheck(entity.get要介護認定状態区分コード())) {
            eucEntity.set受給要介護度(YokaigoJotaiKubunSupport.toValue(FlexibleDate.getNowDate(), entity.get要介護認定状態区分コード()).getName());
        } else {
            eucEntity.set受給要介護度(RString.EMPTY);
        }
        eucEntity.set受給認定開始日(set日付編集(entity.get認定有効期間開始年月日()));
        eucEntity.set受給認定終了日(set日付編集(entity.get認定有効期間終了年月日()));
        eucEntity.set受給認定日(set日付編集(entity.get認定年月日()));
        if (entity.is旧措置者フラグ()) {
            eucEntity.set受給旧措置(new RString("旧措置者"));
        } else {
            eucEntity.set受給旧措置(RString.EMPTY);
        }
        eucEntity.set受給みなし更新認定(get受給みなし更新認定(entity.getみなし要介護区分コード()));
        if (!isNullCheck(entity.get直近異動事由コード())) {
            eucEntity.set受給直近事由(ChokkinIdoJiyuCode.toValue(entity.get直近異動事由コード()).get名称());
        }
        eucEntity.set有効開始年月(entity.get有効開始年月());
        eucEntity.set有効終了年月(entity.get有効終了年月());
        eucEntity.set拡大倍数(new RString(entity.get拡大倍数()));
        eucEntity.set拡大支給限度額(entity.get切り分け単位数());
        eucEntity.set限度額管理期間数(entity.get限度額管理期間数());
        eucEntity.set登録年月日(set日付編集(entity.get登録年月日()));
        eucEntity.set変更年月日(set日付編集(entity.get変更年月日()));
        return eucEntity;
    }

    /**
     * TankiNyushoKakudaiGaitoshaReibanAriEUCEntityの設定クラスです。
     *
     * @return JigyoBunKogakuGassanShikyuKetteibanAriEUCEntity
     */
    public TankiNyushoKakudaiGaitoshaReibanAriEUCEntity set連番ありEUCEntity() {
        TankiNyushoKakudaiGaitoshaReibanAriEUCEntity eucEntity = new TankiNyushoKakudaiGaitoshaReibanAriEUCEntity();
        eucEntity.set連番(null);
        eucEntity.set識別コード(null);
        eucEntity.set住民種別(null);
        eucEntity.set氏名(null);
        eucEntity.set氏名カナ(null);
        eucEntity.set生年月日(null);
        eucEntity.set年齢(null);
        eucEntity.set性別(null);
        eucEntity.set続柄コード(null);
        eucEntity.set世帯コード(null);
        eucEntity.set世帯主名(null);
        eucEntity.set住所コード(null);
        eucEntity.set郵便番号(null);
        eucEntity.set住所_番地_方書(null);
        eucEntity.set住所(null);
        eucEntity.set番地(null);
        eucEntity.set方書(null);
        eucEntity.set行政区コード(null);
        eucEntity.set行政区名(null);
        eucEntity.set地区１(null);
        eucEntity.set地区２(null);
        eucEntity.set地区３(null);
        eucEntity.set連絡先１(null);
        eucEntity.set連絡先２(null);
        eucEntity.set登録異動日(null);
        eucEntity.set登録事由(null);
        eucEntity.set登録届出日(null);
        eucEntity.set住定異動日(null);
        eucEntity.set住定事由(null);
        eucEntity.set住定届出日(null);
        eucEntity.set消除異動日(null);
        eucEntity.set消除事由(null);
        eucEntity.set消除届出日(null);
        eucEntity.set転出入理由(null);
        eucEntity.set前住所郵便番号(null);
        eucEntity.set前住所_番地_方書(null);
        eucEntity.set前住所(null);
        eucEntity.set前住所番地(null);
        eucEntity.set前住所方書(null);
        eucEntity.set市町村コード(null);
        eucEntity.set市町村名(null);
        eucEntity.set保険者コード(null);
        eucEntity.set保険者名(null);
        eucEntity.set空白(null);
        eucEntity.set被保険者番号(null);
        eucEntity.set資格取得事由(null);
        eucEntity.set資格取得日(null);
        eucEntity.set資格取得届出日(null);
        eucEntity.set喪失事由(null);
        eucEntity.set資格喪失日(null);
        eucEntity.set資格喪失届日(null);
        eucEntity.set資格区分(null);
        eucEntity.set住所地特例状態(null);
        eucEntity.set資格_証記載保険者番号(null);
        eucEntity.set有効開始年月(null);
        eucEntity.set有効終了年月(null);
        eucEntity.set拡大倍数(null);
        eucEntity.set拡大支給限度額(null);
        eucEntity.set限度額管理期間数(null);
        eucEntity.set登録年月日(null);
        eucEntity.set変更年月日(null);
        eucEntity.set受給申請事由(null);
        eucEntity.set受給申請日(null);
        eucEntity.set受給要介護度(null);
        eucEntity.set受給認定開始日(null);
        eucEntity.set受給認定終了日(null);
        eucEntity.set受給認定日(null);
        eucEntity.set受給旧措置(null);
        eucEntity.set受給みなし更新認定(null);
        eucEntity.set受給直近事由(null);

        return eucEntity;
    }

    /**
     * TankiNyushoKakudaiGaitoshaReibanNashiEUCEntityの設定クラスです。
     *
     * @param entity entity
     * @param 市町村名MasterMap 市町村名MasterMap
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     * @param association association
     * @param 導入団体情報 Association
     * @return TankiNyushoKakudaiGaitoshaReibanNashiEUCEntity
     */
    public TankiNyushoKakudaiGaitoshaReibanNashiEUCEntity set連番なしEUCEntity(TankiNyushoKakudaiGaitoshaRelateEntity entity,
            Map<RString, KoseiShichosonMaster> 市町村名MasterMap,
            ChohyoSeigyoKyotsu 帳票制御共通, Association association, Association 導入団体情報) {
        TankiNyushoKakudaiGaitoshaReibanNashiEUCEntity eucEntity = new TankiNyushoKakudaiGaitoshaReibanNashiEUCEntity();
        UaFt200FindShikibetsuTaishoEntity 宛名Entity = entity.get宛名Entity();
        if (宛名Entity != null) {
            IShikibetsuTaisho iShikibetsuTaisho = ShikibetsuTaishoFactory.createKojin(宛名Entity);
            IKojin iKojin = iShikibetsuTaisho.to個人();
            personalDataList.add(toPersonalData(entity.get被保険者番号(), iKojin.get識別コード()));
            eucEntity.set識別コード(iKojin.get識別コード());
            eucEntity.set住民種別(iKojin.get住民状態().住民状態略称());
            eucEntity.set氏名(iKojin.get名称().getName());
            eucEntity.set氏名カナ(iKojin.get名称().getKana());
            eucEntity.set生年月日(set日付編集(iKojin.get生年月日().toFlexibleDate()));
            eucEntity.set年齢(iKojin.get年齢算出().get年齢());
            eucEntity.set性別(iKojin.get性別().getName().getShortJapanese());
            eucEntity.set続柄コード(iKojin.get続柄コードリスト().toTsuzukigaraCode());
            eucEntity.set世帯コード(iKojin.get世帯コード());
            eucEntity.set世帯主名(iKojin.get世帯主名());
            eucEntity.set住所コード(iKojin.get住所().get町域コード().value());
            eucEntity.set郵便番号(iKojin.get住所().get郵便番号().getEditedYubinNo());
            eucEntity.set住所_番地_方書(JushoHenshu.editJusho(帳票制御共通, iKojin, 導入団体情報));
            eucEntity.set住所(iKojin.get住所().get住所());
            eucEntity.set番地(get番地(iKojin.get住所().get番地()));
            eucEntity.set方書(get方書(iKojin.get住所().get方書()));
            eucEntity.set行政区コード(iKojin.get行政区画().getGyoseiku().getコード());
            eucEntity.set行政区名(iKojin.get行政区画().getGyoseiku().get名称());
            eucEntity.set地区１(iKojin.get行政区画().getChiku1().getコード());
            eucEntity.set地区２(iKojin.get行政区画().getChiku2().getコード());
            eucEntity.set地区３(iKojin.get行政区画().getChiku3().getコード());
            eucEntity.set連絡先１(iKojin.get連絡先１());
            eucEntity.set連絡先２(iKojin.get連絡先２());
            eucEntity.set登録異動日(set日付編集(iKojin.get登録異動年月日()));
            eucEntity.set登録事由(iKojin.get登録事由());
            eucEntity.set登録届出日(set日付編集(iKojin.get登録届出年月日()));
            eucEntity.set住定異動日(set日付編集(iKojin.get住定異動年月日()));
            eucEntity.set住定事由(iKojin.get住定事由());
            eucEntity.set住定届出日(set日付編集(iKojin.get住定届出年月日()));
            eucEntity.set消除異動日(set日付編集(iKojin.get消除異動年月日()));
            eucEntity.set消除事由(iKojin.get消除事由());
            eucEntity.set消除届出日(set日付編集(iKojin.get消除届出年月日()));
            eucEntity.set転出入理由(RString.EMPTY);
            eucEntity.set前住所郵便番号(iKojin.get転入前().get郵便番号().getEditedYubinNo());
            eucEntity.set前住所_番地_方書(get住所_番地_方書(iKojin.get転入前().get住所(),
                    get番地(iKojin.get転入前().get番地()), get方書(iKojin.get転入前().get方書())));
            eucEntity.set前住所(iKojin.get転入前().get住所());
            eucEntity.set前住所番地(get番地(iKojin.get転入前().get番地()));
            eucEntity.set前住所方書(get方書(iKojin.get転入前().get方書()));
            eucEntity.set市町村コード(entity.get市町村コード());
        }
        if (市町村名MasterMap != null && !市町村名MasterMap.isEmpty()) {
            eucEntity.set市町村名(市町村名MasterMap.get(entity.get市町村コード()).get市町村名称());
        }
        eucEntity.set保険者コード(association.get地方公共団体コード().value());
        eucEntity.set保険者名(association.get市町村名());
        eucEntity.set空白(RString.HALF_SPACE);
        eucEntity.set被保険者番号(entity.get被保険者番号());
        eucEntity.set資格取得事由(getCodeNameByCode(DBACodeShubetsu.介護資格取得事由_被保険者.getCodeShubetsu(), entity.get資格取得事由コード()));
        eucEntity.set資格取得日(set日付編集(entity.get資格取得年月日()));
        eucEntity.set資格取得届出日(set日付編集(entity.get資格取得届出年月日()));
        eucEntity.set喪失事由(getCodeNameByCode(DBACodeShubetsu.介護資格喪失事由_被保険者.getCodeShubetsu(), entity.get資格喪失事由コード()));
        eucEntity.set資格喪失日(set日付編集(entity.get資格喪失年月日()));
        eucEntity.set資格喪失届日(set日付編集(entity.get資格喪失届出年月日()));
        eucEntity.set資格区分(HihokenshaKubunCode.toValue(entity.get被保険者区分コード()).get名称());
        if (文字1.equals(entity.get住所地特例フラグ())) {
            eucEntity.set住所地特例状態(new RString("住特"));
        }
        eucEntity.set資格_証記載保険者番号(get証記載保険者番号(entity, 市町村名MasterMap));
        eucEntity.set受給申請事由(get受給申請事由(entity));
        eucEntity.set受給申請日(set日付編集(entity.get受給申請年月日()));
        if (!isNullCheck(entity.get要介護認定状態区分コード())) {
            eucEntity.set受給要介護度(YokaigoJotaiKubunSupport.toValue(FlexibleDate.getNowDate(), entity.get要介護認定状態区分コード()).getName());
        } else {
            eucEntity.set受給要介護度(RString.EMPTY);
        }
        eucEntity.set受給認定開始日(set日付編集(entity.get認定有効期間開始年月日()));
        eucEntity.set受給認定終了日(set日付編集(entity.get認定有効期間終了年月日()));
        eucEntity.set受給認定日(set日付編集(entity.get認定年月日()));
        if (entity.is旧措置者フラグ()) {
            eucEntity.set受給旧措置(new RString("旧措置者"));
        } else {
            eucEntity.set受給旧措置(RString.EMPTY);
        }
        eucEntity.set受給みなし更新認定(get受給みなし更新認定(entity.getみなし要介護区分コード()));
        if (!isNullCheck(entity.get直近異動事由コード())) {
            eucEntity.set受給直近事由(ChokkinIdoJiyuCode.toValue(entity.get直近異動事由コード()).get名称());
        }
        eucEntity.set有効開始年月(entity.get有効開始年月());
        eucEntity.set有効終了年月(entity.get有効終了年月());
        eucEntity.set拡大倍数(new RString(entity.get拡大倍数()));
        eucEntity.set拡大支給限度額(entity.get切り分け単位数());
        eucEntity.set限度額管理期間数(entity.get限度額管理期間数());
        eucEntity.set登録年月日(set日付編集(entity.get登録年月日()));
        eucEntity.set変更年月日(set日付編集(entity.get変更年月日()));
        return eucEntity;
    }

    /**
     * TankiNyushoKakudaiGaitoshaReibanNashiEUCEntityの設定クラスです。
     *
     * @return TankiNyushoKakudaiGaitoshaReibanNashiEUCEntity
     */
    public TankiNyushoKakudaiGaitoshaReibanNashiEUCEntity set連番なしEUCEntity() {
        TankiNyushoKakudaiGaitoshaReibanNashiEUCEntity eucEntity = new TankiNyushoKakudaiGaitoshaReibanNashiEUCEntity();
        eucEntity.set識別コード(null);
        eucEntity.set住民種別(null);
        eucEntity.set氏名(null);
        eucEntity.set氏名カナ(null);
        eucEntity.set生年月日(null);
        eucEntity.set年齢(null);
        eucEntity.set性別(null);
        eucEntity.set続柄コード(null);
        eucEntity.set世帯コード(null);
        eucEntity.set世帯主名(null);
        eucEntity.set住所コード(null);
        eucEntity.set郵便番号(null);
        eucEntity.set住所_番地_方書(null);
        eucEntity.set住所(null);
        eucEntity.set番地(null);
        eucEntity.set方書(null);
        eucEntity.set行政区コード(null);
        eucEntity.set行政区名(null);
        eucEntity.set地区１(null);
        eucEntity.set地区２(null);
        eucEntity.set地区３(null);
        eucEntity.set連絡先１(null);
        eucEntity.set連絡先２(null);
        eucEntity.set登録異動日(null);
        eucEntity.set登録事由(null);
        eucEntity.set登録届出日(null);
        eucEntity.set住定異動日(null);
        eucEntity.set住定事由(null);
        eucEntity.set住定届出日(null);
        eucEntity.set消除異動日(null);
        eucEntity.set消除事由(null);
        eucEntity.set消除届出日(null);
        eucEntity.set転出入理由(null);
        eucEntity.set前住所郵便番号(null);
        eucEntity.set前住所_番地_方書(null);
        eucEntity.set前住所(null);
        eucEntity.set前住所番地(null);
        eucEntity.set前住所方書(null);
        eucEntity.set市町村コード(null);
        eucEntity.set市町村名(null);
        eucEntity.set保険者コード(null);
        eucEntity.set保険者名(null);
        eucEntity.set空白(null);
        eucEntity.set被保険者番号(null);
        eucEntity.set資格取得事由(null);
        eucEntity.set資格取得日(null);
        eucEntity.set資格取得届出日(null);
        eucEntity.set喪失事由(null);
        eucEntity.set資格喪失日(null);
        eucEntity.set資格喪失届日(null);
        eucEntity.set資格区分(null);
        eucEntity.set住所地特例状態(null);
        eucEntity.set資格_証記載保険者番号(null);
        eucEntity.set有効開始年月(null);
        eucEntity.set有効終了年月(null);
        eucEntity.set拡大倍数(null);
        eucEntity.set拡大支給限度額(null);
        eucEntity.set限度額管理期間数(null);
        eucEntity.set登録年月日(null);
        eucEntity.set変更年月日(null);
        eucEntity.set受給申請事由(null);
        eucEntity.set受給申請日(null);
        eucEntity.set受給要介護度(null);
        eucEntity.set受給認定開始日(null);
        eucEntity.set受給認定終了日(null);
        eucEntity.set受給認定日(null);
        eucEntity.set受給旧措置(null);
        eucEntity.set受給みなし更新認定(null);
        eucEntity.set受給直近事由(null);
        return eucEntity;
    }

    private RString get証記載保険者番号(TankiNyushoKakudaiGaitoshaRelateEntity entity, Map<RString, KoseiShichosonMaster> 市町村名MasterMap) {
        RString 証記載保険者番号 = null;
        if (文字1.equals(entity.get広域内住所地特例フラグ()) && 市町村名MasterMap != null && !市町村名MasterMap.isEmpty()) {
            if (!isNullCheck(entity.get広住特措置元市町村コード())) {
                証記載保険者番号 = 市町村名MasterMap.get(entity.get広住特措置元市町村コード()).get証記載保険者番号().value();
            }
        } else if (市町村名MasterMap != null && !市町村名MasterMap.isEmpty()) {
            証記載保険者番号 = 市町村名MasterMap.get(entity.get市町村コード()).get証記載保険者番号().value();
        }
        return 証記載保険者番号;
    }

    private RString get受給申請事由(TankiNyushoKakudaiGaitoshaRelateEntity entity) {
        List jukyuShinseiJiyuList = new ArrayList();
        RString 受給申請事由 = RString.EMPTY;
        RString 受給申請事由コード = entity.get受給申請事由();
        for (JukyuShinseiJiyu jukyuShinseiJiyu : JukyuShinseiJiyu.values()) {
            jukyuShinseiJiyuList.add(jukyuShinseiJiyu.getコード());
        }
        if (jukyuShinseiJiyuList.contains(受給申請事由コード)) {
            受給申請事由 = getJukyuShinseiJiyu(受給申請事由コード, 受給申請事由, entity.get資格取得事由コード());
        }
        return 受給申請事由;
    }

    private RString getJukyuShinseiJiyu(RString 受給申請事由コード, RString 受給申請事由, RString 要支援者認定申請区分) {
        if (JukyuShinseiJiyu.初回申請.getコード().equals(受給申請事由コード)) {
            受給申請事由 = new RString("初回申請　　");
        } else if (JukyuShinseiJiyu.再申請_有効期限内.getコード().equals(受給申請事由コード)) {
            受給申請事由 = new RString("再申請内　　");
        } else if (JukyuShinseiJiyu.再申請_有効期限外.getコード().equals(受給申請事由コード)) {
            受給申請事由 = new RString("再申請外　　");
        } else if (JukyuShinseiJiyu.要介護度変更申請.getコード().equals(受給申請事由コード)) {
            if (NinteiShienShinseiKubun.認定支援申請.getコード().equals(要支援者認定申請区分)) {
                受給申請事由 = new RString("支援から申請");
            } else {
                受給申請事由 = new RString("区分変更申請");
            }
        } else if (JukyuShinseiJiyu.指定サービス種類変更申請.getコード().equals(受給申請事由コード)) {
            受給申請事由 = new RString("サ変更申請　");
        } else if (JukyuShinseiJiyu.申請_法施行前.getコード().equals(受給申請事由コード)) {
            受給申請事由 = new RString("施行前申請　");
        } else if (JukyuShinseiJiyu.追加_申請なしの追加.getコード().equals(受給申請事由コード)) {
            受給申請事由 = new RString("追加　　　　");
        }
        return 受給申請事由;
    }

    private RString get受給みなし更新認定(RString みなし要介護区分コード) {
        RString 受給みなし更新認定 = RString.EMPTY;
        List minashiCodeList = new ArrayList();
        for (MinashiCode minashiCode : MinashiCode.values()) {
            minashiCodeList.add(minashiCode.getコード());
        }
        if (minashiCodeList.contains(みなし要介護区分コード) && !MinashiCode.通常の認定.getコード().equals(みなし要介護区分コード)) {
            受給みなし更新認定 = new RString("みなし");
        }
        return 受給みなし更新認定;
    }

    private RString getCodeNameByCode(CodeShubetsu codeShubetsu, RString code) {
        if (code == null || code.isEmpty()) {
            return RString.EMPTY;
        }
        return CodeMaster.getCodeRyakusho(
                SubGyomuCode.DBA介護資格,
                codeShubetsu,
                new Code(code),
                FlexibleDate.getNowDate());
    }

    private RString set日付編集(RString value) {
        RString 日付 = RString.EMPTY;
        if (processParameter.is日付編集() && !RString.isNullOrEmpty(value)) {
            日付 = new FlexibleDate(value).seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
        }
        return 日付;
    }

    private RString set日付編集(FlexibleDate value) {
        RString 日付 = RString.EMPTY;
        if (value != null && !value.isEmpty()) {
            if (processParameter.is日付編集()) {
                日付 = value.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
            } else {
                日付 = new RString(value.toString());
            }
        }
        return 日付;
    }

    private RString get住所_番地_方書(RString 住所, RString 番地, RString 方書) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(住所);
        builder.append(番地);
        builder.append(RString.FULL_SPACE);
        builder.append(方書);
        return builder.toRString();
    }

    private RString get方書(Katagaki katagaki) {
        RString 方書 = RString.EMPTY;
        if (katagaki != null) {
            方書 = katagaki.value();
        }
        return 方書;
    }

    private RString get番地(Banchi banchi) {
        RString 番地 = RString.EMPTY;
        if (banchi != null) {
            番地 = banchi.getBanchi().value();
        }
        return 番地;
    }

    /**
     * アクセスログを出力するメッソドです。
     *
     * @return AccessLogUUID
     */
    public AccessLogUUID getアクセスログ() {
        return AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
    }

    private PersonalData toPersonalData(RString 被保険者番号, ShikibetsuCode 識別コード) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), 被保険者番号);
        return PersonalData.of(識別コード, expandedInfo);
    }

    /**
     * 出力条件を作成するメッソドです。
     *
     * @return List<RString>
     */
    public List<RString> set出力条件() {
        RStringBuilder jokenBuilder = new RStringBuilder();
        List<RString> 出力条件List = new ArrayList<>();
        jokenBuilder.append(new RString("【抽出条件】"));
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        if (RString.isNullOrEmpty(processParameter.get保険者コード())) {
            jokenBuilder.append(RString.EMPTY);
        } else if (new RString("000000").equals(processParameter.get保険者コード())) {
            jokenBuilder.append(new RString("保険者："));
            jokenBuilder.append(new RString("000000 全市町村"));
        } else {
            jokenBuilder.append(new RString("保険者："));
            RStringBuilder 市町村名builder = new RStringBuilder();
            市町村名builder.append(processParameter.get保険者コード());
            市町村名builder.append(RString.HALF_SPACE);
            市町村名builder.append(processParameter.get保険者名());
            jokenBuilder.append(市町村名builder.toRString());
        }
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(new RString("抽出区分："));
        jokenBuilder.append(ChushutsuKubun.toValue(processParameter.get抽出区分()).get名称());
        出力条件List.add(jokenBuilder.toRString());
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(new RString("適用開始年月："));
        出力条件List.add(get期間(jokenBuilder, processParameter.get適用開始年月From(), processParameter.get適用開始年月To()));
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(new RString("適用終了年月："));
        出力条件List.add(get期間(jokenBuilder, processParameter.get適用終了年月From(), processParameter.get適用終了年月To()));
        jokenBuilder = new RStringBuilder();
        jokenBuilder.append(new RString("限度額管理期間数："));
        jokenBuilder.append(GendogakuKanriKikansu.toValue(processParameter.get限度額管理期間数()).get名称());
        出力条件List.add(jokenBuilder.toRString());
        return 出力条件List;
    }

    private RString get期間(RStringBuilder jokenBuilder, RString fromYMD, RString toYMD) {
        if (!RString.isNullOrEmpty(fromYMD)) {
            jokenBuilder.append(new FlexibleDate(fromYMD).getYearMonth().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        }
        jokenBuilder.append(new RString("　～　"));
        if (!RString.isNullOrEmpty(toYMD)) {
            jokenBuilder.append(new FlexibleDate(toYMD).getYearMonth().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        }
        return jokenBuilder.toRString();
    }

    private boolean isNullCheck(RString value) {
        return RString.isNullOrEmpty(value);
    }

    /**
     * MybatisParameterを設定するメッソドです。
     *
     * @param 出力順 出力順
     * @return KijunShunyugakuTekiyoMybatisParameter
     */
    public TankiNyushoKakudaiGaitoshaMybatisParameter createMybatisParameter(RString 出力順) {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        return TankiNyushoKakudaiGaitoshaMybatisParameter.createMybatisParameter(processParameter.get保険者コード(),
                processParameter.get抽出区分(),
                processParameter.get適用開始年月From(),
                processParameter.get適用開始年月To(),
                processParameter.get適用終了年月From(),
                processParameter.get適用終了年月To(),
                processParameter.get限度額管理期間数(),
                new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()),
                出力順);
    }

    /**
     * 帳票分類ID「DBC701013_HanyoListTankiNyushoKakudaiGaitosha」（汎用リスト_短期入所拡大該当者）出力順設定可能項目です。
     */
    public enum ShutsuryokujunEnum implements IReportItems {

        /**
         * 行政区コード
         */
        行政区コード(new RString("0004"), new RString(""), new RString("\"ShikibetsuTaisho_gyoseikuCode\"")),
        /**
         * 世帯コード
         */
        世帯コード(new RString("0008"), new RString(""), new RString("\"ShikibetsuTaisho_setaiCode\"")),
        /**
         * 識別コード
         */
        識別コード(new RString("0009"), new RString(""), new RString("\"ShikibetsuTaisho_shikibetsuCode\"")),
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString(""), new RString("\"ShikibetsuTaisho_kanaShimei\"")),
        /**
         * 市町村コード
         */
        市町村コード(new RString("0016"), new RString(""), new RString("\"shichosonCode\"")),
        /**
         * 証記載保険者番号
         */
        証記載保険者番号(new RString("0103"), new RString(""), new RString("\"hihokenshaNo\"")),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString(""), new RString("\"hihokenshaNo\"")),
        /**
         * 要介護度
         */
        要介護度(new RString("0403"), new RString(""), new RString("\"yokaigoJotaiKubunCode\"")),
        /**
         * 認定開始日
         */
        認定開始日(new RString("0411"), new RString(""), new RString("\"ninteiYukoKikanKaishiYMD\"")),
        /**
         * 有効開始年月
         */
        有効開始年月(new RString("0502"), new RString(""), new RString("\"yukoKaishiYM\""));

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private ShutsuryokujunEnum(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
            this.項目ID = 項目ID;
            this.フォームフィールド名 = フォームフィールド名;
            this.myBatis項目名 = myBatis項目名;
        }

        @Override
        public RString get項目ID() {
            return 項目ID;
        }

        @Override
        public RString getフォームフィールド名() {
            return フォームフィールド名;
        }

        @Override
        public RString getMyBatis項目名() {
            return myBatis項目名;
        }

    }

}
