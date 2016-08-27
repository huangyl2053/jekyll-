/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * DBDMN32001_2_支払方法変更滞納者把握リスト作成_バッチプロセス5SQL検索結果クラスです．
 *
 * @reamsid_L DBD-3650-040 x_lilh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShiharaiHohoHenkoHaakuOneEntity {

    private RString 生保;
    private UaFt200FindShikibetsuTaishoEntity psmEntity;

    // 対象者情報
    private HihokenshaNo 対象者情報_被保険者番号;
    //資格情報
    private HihokenshaNo 資格情報_資格情報険者番号;
    private FlexibleDate 資格情報_異動日;
    private RString 資格情報_枝番;
    private RString 資格情報_異動事由コード;
    private LasdecCode 資格情報_市町村コード;
    private ShikibetsuCode 資格情報_識別コード;
    private RString 資格情報_資格取得事由コード;
    private FlexibleDate 資格情報_資格取得年月日;
    private FlexibleDate 資格情報_資格取得届出年月日;
    private FlexibleDate 資格情報_第1号資格取得年月日;
    private RString 資格情報_資格情報険者区分コード;
    private RString 資格情報_資格喪失事由コード;
    private FlexibleDate 資格情報_資格喪失年月日;
    private FlexibleDate 資格情報_資格喪失届出年月日;
    private RString 資格情報_資格変更事由コード;
    private FlexibleDate 資格情報_資格変更年月日;
    private FlexibleDate 資格情報_資格変更届出年月日;
    private RString 資格情報_住所地特例適用事由コード;
    private FlexibleDate 資格情報_適用年月日;
    private FlexibleDate 資格情報_適用届出年月日;
    private RString 資格情報_住所地特例解除事由コード;
    private FlexibleDate 資格情報_解除年月日;
    private FlexibleDate 資格情報_解除届出年月日;
    private RString 資格情報_住所地特例フラグ;
    private RString 資格情報_広域内住所地特例フラグ;
    private LasdecCode 資格情報_広住特措置元市町村コード;
    private LasdecCode 資格情報_旧市町村コード;
    private boolean 資格情報_論理削除フラグ;

    //認定情報
    private LasdecCode 認定情報_市町村コード;
    private HihokenshaNo 認定情報_被保険者番号;
    private RString 認定情報_履歴番号;
    private RString 認定情報_枝番;
    private ShinseishoKanriNo 認定情報_申請書管理番号;
    private RString 認定情報_申請状況区分;
    private RString 認定情報_支所コード;
    private boolean 認定情報_直近フラグ;
    private ShikibetsuCode 認定情報_識別コード;
    private Code 認定情報_受給申請事由;
    private RString 認定情報_申請理由;
    private Code 認定情報_届出者_申請者関係コード;
    private RString 認定情報_届出者_本人との関係;
    private FlexibleDate 認定情報_受給申請年月日;
    private Code 認定情報_２号特定疾病コード;
    private FlexibleDate 認定情報_審査会依頼年月日;
    private Code 認定情報_要介護認定状態区分コード;
    private FlexibleDate 認定情報_認定有効期間開始年月日;
    private FlexibleDate 認定情報_認定有効期間終了年月日;
    private FlexibleDate 認定情報_認定年月日;
    private Code 認定情報_みなし要介護区分コード;
    private ServiceShuruiCode 認定情報_指定サービス種類01;
    private ServiceShuruiCode 認定情報_指定サービス種類02;
    private ServiceShuruiCode 認定情報_指定サービス種類03;
    private ServiceShuruiCode 認定情報_指定サービス種類04;
    private ServiceShuruiCode 認定情報_指定サービス種類05;
    private ServiceShuruiCode 認定情報_指定サービス種類06;
    private ServiceShuruiCode 認定情報_指定サービス種類07;
    private ServiceShuruiCode 認定情報_指定サービス種類08;
    private ServiceShuruiCode 認定情報_指定サービス種類09;
    private ServiceShuruiCode 認定情報_指定サービス種類10;
    private ServiceShuruiCode 認定情報_指定サービス種類11;
    private ServiceShuruiCode 認定情報_指定サービス種類12;
    private ServiceShuruiCode 認定情報_指定サービス種類13;
    private ServiceShuruiCode 認定情報_指定サービス種類14;
    private ServiceShuruiCode 認定情報_指定サービス種類15;
    private ServiceShuruiCode 認定情報_指定サービス種類16;
    private ServiceShuruiCode 認定情報_指定サービス種類17;
    private ServiceShuruiCode 認定情報_指定サービス種類18;
    private ServiceShuruiCode 認定情報_指定サービス種類19;
    private ServiceShuruiCode 認定情報_指定サービス種類20;
    private ServiceShuruiCode 認定情報_指定サービス種類21;
    private ServiceShuruiCode 認定情報_指定サービス種類22;
    private ServiceShuruiCode 認定情報_指定サービス種類23;
    private ServiceShuruiCode 認定情報_指定サービス種類24;
    private ServiceShuruiCode 認定情報_指定サービス種類25;
    private ServiceShuruiCode 認定情報_指定サービス種類26;
    private ServiceShuruiCode 認定情報_指定サービス種類27;
    private ServiceShuruiCode 認定情報_指定サービス種類28;
    private ServiceShuruiCode 認定情報_指定サービス種類29;
    private ServiceShuruiCode 認定情報_指定サービス種類30;
    private FlexibleDate 認定情報_喪失年月日;
    private FlexibleDate 認定情報_直近異動年月日;
    private Code 認定情報_直近異動事由コード;
    private Code 認定情報_有効無効区分;
    private Code 認定情報_データ区分;
    private RString 認定情報_同一連番;
    private RString 認定情報_異動理由;
    private Code 認定情報_申請書区分;
    private Code 認定情報_削除事由コード;
    private boolean 認定情報_要支援者認定申請区分;
    private Decimal 認定情報_支給限度単位数;
    private FlexibleDate 認定情報_支給限度有効開始年月日;
    private FlexibleDate 認定情報_支給限度有効終了年月日;
    private int 認定情報_短期入所支給限度日数;
    private FlexibleDate 認定情報_短期入所支給限度開始年月日;
    private FlexibleDate 認定情報_短期入所支給限度終了年月日;
    private FlexibleDate 認定情報_当初認定有効開始年月日;
    private FlexibleDate 認定情報_当初認定有効終了年月日;
    private FlexibleDate 認定情報_受給資格証明書発行年月日１;
    private FlexibleDate 認定情報_受給資格証明書発行年月日２;
    private FlexibleDate 認定情報_診断命令書発行年月日;
    private FlexibleDate 認定情報_２号申請受理通知書発行年月日;
    private FlexibleDate 認定情報_認定結果通知書発行年月日;
    private FlexibleDate 認定情報_区分変更通知書発行年月日;
    private FlexibleDate 認定情報_サービス変更通知書発行年月日;
    private FlexibleDate 認定情報_認定却下通知書発行年月日;
    private FlexibleDate 認定情報_認定取消通知書発行年月日;
    private boolean 認定情報_資格取得前申請フラグ;
    private boolean 認定情報_旧措置者フラグ;
    private boolean 認定情報_論理削除フラグ;

    //賦課
    private FlexibleYear 賦課_調定年度;
    private FlexibleYear 賦課_賦課年度;
    private TsuchishoNo 賦課_通知書番号;
    private int 賦課_履歴番号;
    private HihokenshaNo 賦課_被保険者番号;
    private ShikibetsuCode 賦課_識別コード;
    private SetaiCode 賦課_世帯コード;
    private int 賦課_世帯員数;
    private FlexibleDate 賦課_資格取得日;
    private RString 賦課_資格取得事由;
    private FlexibleDate 賦課_資格喪失日;
    private RString 賦課_資格喪失事由;
    private RString 賦課_生活保護扶助種類;
    private FlexibleDate 賦課_生保開始日;
    private FlexibleDate 賦課_生保廃止日;
    private FlexibleDate 賦課_老年開始日;
    private FlexibleDate 賦課_老年廃止日;
    private FlexibleDate 賦課_賦課期日;
    private RString 賦課_課税区分;
    private RString 賦課_世帯課税区分;
    private Decimal 賦課_合計所得金額;
    private Decimal 賦課_公的年金収入額;
    private RString 賦課_保険料段階;
    private RString 賦課_保険料算定段階1;
    private Decimal 賦課_算定年額保険料1;
    private FlexibleYearMonth 賦課_月割開始年月1;
    private FlexibleYearMonth 賦課_月割終了年月1;
    private RString 賦課_保険料算定段階2;
    private Decimal 賦課_算定年額保険料2;
    private FlexibleYearMonth 賦課_月割開始年月2;
    private FlexibleYearMonth 賦課_月割終了年月2;
    private YMDHMS 賦課_調定日時;
    private RString 賦課_調定事由1;
    private RString 賦課_調定事由2;
    private RString 賦課_調定事由3;
    private RString 賦課_調定事由4;
    private RString 賦課_更正月;
    private Decimal 賦課_減免前介護保険料_年額;
    private Decimal 賦課_減免額;
    private Decimal 賦課_確定介護保険料年額;
    private RString 賦課_保険料段階_仮算定時;
    private int 賦課_徴収方法履歴番号;
    private YMDHMS 賦課_異動基準日時;
    private RString 賦課_口座区分;
    private RString 賦課_境界層区分;
    private RString 賦課_職権区分;
    private LasdecCode 賦課_賦課市町村コード;
    private Decimal 賦課_特徴歳出還付額;
    private Decimal 賦課_普徴歳出還付額;

    //介護期別
    private FlexibleYear 介護期別_調定年度;
    private FlexibleYear 介護期別_賦課年度;
    private TsuchishoNo 介護期別_通知書番号;
    private int 介護期別_履歴番号;
    private RString 介護期別_徴収方法;
    private int 介護期別_期;
    private Decimal 介護期別_調定ID;

    //調定共通_介護継承
    private Long 調定共通_介護継承_調定ID;
    private int 調定共通_介護継承_履歴番号;
    private Long 調定共通_介護継承_収納ID;
    private RYear 調定共通_介護継承_会計年度;
    private RYear 調定共通_介護継承_処理年度;
    private int 調定共通_介護継承_処理番号;
    private int 調定共通_介護継承_更正回数;
    private RString 調定共通_介護継承_調定事由コード;
    private RDate 調定共通_介護継承_調定年月日;
    private Decimal 調定共通_介護継承_調定額;
    private Decimal 調定共通_介護継承_消費税額;
    private RDate 調定共通_介護継承_納期限;
    private RDate 調定共通_介護継承_法定納期限等;
    private boolean 調定共通_介護継承_賦課処理状況;

    //時効
    private ShoKisaiHokenshaNo 時効_証記載保険者番号;
    private HihokenshaNo 時効_被保険者番号;
    private RYear 時効_調定年度;
    private RYear 時効_賦課年度;
    private RString 時効_特徴_普徴区分;
    private TsuchishoNo 時効_通知書番号;
    private RString 時効_収納期_月;
    private int 時効_履歴番号;
    private FlexibleDate 時効_時効起算年月日;
    private RString 時効_時効起算日区分;
    private boolean 時効_論理削除フラグ;

    //収入
    private RString 収入ID;
    private RString 収納ID;
    private Decimal 収入額;
    private FlexibleDate 収入日;

    //督促状発行履歴
    private RString 督促状発行履歴_収納ID;
    private FlexibleDate 督促状発行履歴_督促状発行年月日;
}
