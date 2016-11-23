/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.dbd5010001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd5010001.ChosaDataMobileMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5010001.ChosaDataMobileCsvEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5010001.ChosaDataMobileEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.chosadatamobile.IChosaDataMobileMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping02A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping06A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09B;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping99A;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ChosaKikanKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ChosaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.Sikaku;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.AutoWaritsukeFlag;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaItakuKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaJisshiBashoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.MobileDataShutsuryokuFlag;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinteiChousaIraiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.CopyToSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.CountedItem;
import jp.co.ndensan.reams.uz.uza.util.Saiban;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 画面設計_DBD5010001_完了処理・更新管理のビジネスを生成します。
 *
 * @reamsid_L DBD-2030-010 x_youyj
 */
public class KoshinKanriManager {

    private final MapperProvider mapperProvider;

    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final RString CSV調査ファイル名 = new RString("調査データ（モバイル用）.csv");
    private static final RString 横木 = new RString("-");
    private static final RString 九厚労省IF識別コード_99A = new RString("99A");
    private static final RString 九厚労省IF識別コード_02A = new RString("02A");
    private static final RString 九厚労省IF識別コード_06A = new RString("06A");
    private static final RString 九厚労省IF識別コード_09A = new RString("09A");
    private static final RString 九厚労省IF識別コード_09B = new RString("09B");
    private static final int ZEOR = 0;
    private static final int THREE = 3;
    private static final int SEVEN = 7;

    /**
     * コンストラクタです。
     */
    KoshinKanriManager() {
        mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 画面設計_DBD5010001_完了処理・更新管理のビジネスを生成します。
     *
     * @return 画面設計_DBD5010001_完了処理・更新管理のビジネス
     */
    public static KoshinKanriManager createInstance() {
        return InstanceProvider.create(KoshinKanriManager.class);
    }

    /**
     * 調査データ（モバイル用）の抽出します。
     *
     * @param 申請書管理番号 RString
     * @return SharedFileEntryDescriptor
     */
    @Transaction
    public SharedFileEntryDescriptor get調査データの取得(List<RString> 申請書管理番号) {

        ChosaDataMobileMybatisParameter parameter = new ChosaDataMobileMybatisParameter(申請書管理番号);
        IChosaDataMobileMapper mapper = mapperProvider.create(IChosaDataMobileMapper.class);

        List<ChosaDataMobileEntity> 調査データ情報List = mapper.get調査データの取得(parameter);

        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), CSV調査ファイル名);
        try (CsvWriter<ChosaDataMobileCsvEntity> csvdeTeWriter
                = new CsvWriter.InstanceBuilder(filePath)
                        .alwaysWriteHeader(ChosaDataMobileCsvEntity.class)
                        .canAppend(false)
                        .setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.SJIS)
                        .setNewLine(NewLine.CRLF).hasHeader(true).build()) {
            if (調査データ情報List != null && !調査データ情報List.isEmpty()) {
                for (ChosaDataMobileEntity entity : 調査データ情報List) {
                    csvdeTeWriter.writeLine(setdetaEntity(entity));
                }
            }
        }
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(CSV調査ファイル名));
        sfd = SharedFile.defineSharedFile(sfd);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().isCompressedArchive(false);
        SharedFileEntryDescriptor entry = SharedFile.copyToSharedFile(sfd, new FilesystemPath(filePath), opts);

        return entry;
    }

    /**
     * 認定調査依頼情報の取得
     *
     * @param shinseishoKanriNo RString
     */
    public void get認定調査依頼情報の取得(RString shinseishoKanriNo) {
        IChosaDataMobileMapper mapper = mapperProvider.create(IChosaDataMobileMapper.class);
        DbT4201NinteichosaIraiJohoEntity 認定調査依頼情報 = mapper.get認定調査依頼情報の取得(shinseishoKanriNo);
        if (認定調査依頼情報 != null) {
            認定調査依頼情報.setMobileDataShutsuryokuZumiFlag(MobileDataShutsuryokuFlag.出力済.isモバイルデータ出力());
            KoshinTaishoManager manger = KoshinTaishoManager.createInstance();
            認定調査依頼情報.setState(EntityDataState.Modified);
            manger.updateDbt4201johon(認定調査依頼情報);
        }
    }

    /**
     * 要介護認定申請情報の取得する
     *
     * @param shinseishoKanriNo RString
     */
    public void get要介護認定申請情報の取得(RString shinseishoKanriNo) {
        IChosaDataMobileMapper mapper = mapperProvider.create(IChosaDataMobileMapper.class);
        DbT4101NinteiShinseiJohoEntity 認定申請情報 = mapper.get要介護認定申請情報の取得(shinseishoKanriNo);
        if (認定申請情報 != null) {
//            認定申請情報.setNinteiShinseiShinseijiKubunCode(new Code(NinteiShinseiShinseijiKubunCode.更新申請.getコード()));
            認定申請情報.setKoshinTsuchiHakkoKanryoYMD(FlexibleDate.getNowDate());
            KoshinTaishoManager manger = KoshinTaishoManager.createInstance();
            manger.updateDbt4101johon(認定申請情報);
        }
    }

    /**
     * 調査データ（モバイル用）を出力編集仕様
     *
     * @param sqlEntity SelectSyuuShadeTaEntity
     * @return SelectSyuuShadeTaEntity
     */
    private ChosaDataMobileCsvEntity setdetaEntity(ChosaDataMobileEntity sqlEntity) {
        ChosaDataMobileCsvEntity entity = new ChosaDataMobileCsvEntity();
        entity.set被保険者番号(sqlEntity.get被保険者番号());
        if (sqlEntity.get厚労省IF識別コード() != null && !sqlEntity.get厚労省IF識別コード().isEmpty()) {
            entity.set厚労省認定ソフトのバージョン(KoroshoIfShikibetsuCode.toValue(sqlEntity.get厚労省IF識別コード()).get名称());
        }
        if (sqlEntity.get認定申請年月日() != null) {
            entity.set認定申請年月日(sqlEntity.get認定申請年月日().wareki().toDateString());
        }
        if (sqlEntity.get認定申請区分申請時コード() != null && !sqlEntity.get認定申請区分申請時コード().isEmpty()) {
            entity.set認定申請区分申請時(NinteiShinseiShinseijiKubunCode.toValue(sqlEntity.get認定申請区分申請時コード()).get名称());
        }
        if (sqlEntity.get生年月日() != null) {
            entity.set生年月日(sqlEntity.get生年月日().wareki().toDateString());
        }
        if (sqlEntity.get性別() != null && !sqlEntity.get性別().isEmpty()) {
            entity.set性別(Seibetsu.toValue(sqlEntity.get性別()).get名称());
        }
        if (sqlEntity.get郵便番号() != null && !sqlEntity.get郵便番号().isEmpty()) {
            RString three = sqlEntity.get郵便番号().substring(ZEOR, THREE);
            RString four = sqlEntity.get郵便番号().substring(THREE, SEVEN);
            entity.set郵便番号(three.concat(横木).concat(four));
        }
        if (sqlEntity.get認定調査依頼完了年月日() != null) {
            entity.set認定調査依頼完了年月日(sqlEntity.get認定調査依頼完了年月日().wareki().toDateString());
        }
        if (sqlEntity.get委託先の郵便番号() != null && !sqlEntity.get委託先の郵便番号().isEmpty()) {
            RString three = sqlEntity.get委託先の郵便番号().substring(ZEOR, THREE);
            RString four = sqlEntity.get委託先の郵便番号().substring(THREE, SEVEN);
            entity.set委託先の郵便番号(three.concat(横木).concat(four));
        }
        if (sqlEntity.get調査員の郵便番号() != null) {
            RString three = sqlEntity.get調査員の郵便番号().substring(ZEOR, THREE);
            RString four = sqlEntity.get調査員の郵便番号().substring(THREE, SEVEN);
            entity.set調査員の郵便番号(three.concat(横木).concat(four));
        }
        if (sqlEntity.get認定調査実施年月日() != null) {
            entity.set認定調査実施年月日(sqlEntity.get認定調査実施年月日().wareki().toDateString());
        }
        if (sqlEntity.get認定調査受領年月日() != null) {
            entity.set認定調査受領年月日(sqlEntity.get認定調査受領年月日().wareki().toDateString());
        }
        setVoidEntity2(entity, sqlEntity);
        setVoidEntity(entity, sqlEntity);
        return entity;
    }
    private void setVoidEntity2(ChosaDataMobileCsvEntity entity, ChosaDataMobileEntity sqlEntity) {
        if (sqlEntity.get認定調査実施場所コード() != null && !sqlEntity.get認定調査実施場所コード().isEmpty()) {
            entity.set認定調査実施場所(ChosaJisshiBashoCode.toValue(sqlEntity.get認定調査実施場所コード()).get名称());
        }
        if (sqlEntity.get認定調査サービス区分コード() != null && !sqlEntity.get認定調査サービス区分コード().isEmpty()) {
            entity.set認定調査サービス区分(ServiceKubunCode.toValue(sqlEntity.get認定調査サービス区分コード()).get名称());
        }
        if (sqlEntity.get原本マスク区分コード() != null && !sqlEntity.get原本マスク区分コード().isEmpty()) {
            entity.set原本マスク区分(GenponMaskKubun.toValue(sqlEntity.get原本マスク区分コード()).get名称());
        }
        if (sqlEntity.get認定調査認知症高齢者の日常生活自立度コード() != null
                && !sqlEntity.get認定調査認知症高齢者の日常生活自立度コード().isEmpty()) {
            entity.set認定調査認知症高齢者の日常生活自立度(NinchishoNichijoSeikatsuJiritsudoCode.toValue(
                    sqlEntity.get認定調査認知症高齢者の日常生活自立度コード()).get名称());
        }
        if (sqlEntity.get認定調査障害高齢者の日常生活自立度コード() != null
                && !sqlEntity.get認定調査障害高齢者の日常生活自立度コード().isEmpty()) {
            entity.set認定調査障害高齢者の日常生活自立度(ShogaiNichijoSeikatsuJiritsudoCode.toValue(
                    sqlEntity.get認定調査障害高齢者の日常生活自立度コード()).get名称());
        }
        if (sqlEntity.get認定調査特記事項受領年月日() != null) {
            entity.set認定調査特記事項受領年月日(sqlEntity.get認定調査特記事項受領年月日().wareki().toDateString());
        }
        if (sqlEntity.get調査項目連番() != null && !sqlEntity.get調査項目連番().isEmpty()) {
            if (九厚労省IF識別コード_99A.equals(sqlEntity.get厚労省IF識別コード())) {
                entity.set調査項目文言(NinteichosaKomokuMapping99A.toValue(sqlEntity.get調査項目連番()).get名称());
            } else if (九厚労省IF識別コード_02A.equals(sqlEntity.get厚労省IF識別コード())) {
                entity.set調査項目文言(NinteichosaKomokuMapping02A.toValue(sqlEntity.get調査項目連番()).get名称());
            } else if (九厚労省IF識別コード_06A.equals(sqlEntity.get厚労省IF識別コード())) {
                entity.set調査項目文言(NinteichosaKomokuMapping06A.toValue(sqlEntity.get調査項目連番()).get名称());
            } else if (九厚労省IF識別コード_09A.equals(sqlEntity.get厚労省IF識別コード())) {
                entity.set調査項目文言(NinteichosaKomokuMapping09A.toValue(sqlEntity.get調査項目連番()).get名称());
            } else if (九厚労省IF識別コード_09B.equals(sqlEntity.get厚労省IF識別コード())) {
                entity.set調査項目文言(NinteichosaKomokuMapping09B.toValue(sqlEntity.get調査項目連番()).get名称());
            }
        }
    }

    private void setVoidEntity(ChosaDataMobileCsvEntity entity, ChosaDataMobileEntity sqlEntity) {
        if (sqlEntity.get委託先の調査委託区分() != null && !sqlEntity.get委託先の調査委託区分().isEmpty()) {
            entity.set委託先の調査委託区分(ChosaItakuKubunCode.toValue(sqlEntity.get委託先の調査委託区分()).get名称());
        }
        entity.set委託先の自動割付フラグ(AutoWaritsukeFlag.toValue(sqlEntity.is委託先の自動割付()).get名称());
        if (sqlEntity.get委託先の機関の区分() != null && !sqlEntity.get委託先の機関の区分().isEmpty()) {
            entity.set委託先の機関の区分(ChosaKikanKubun.toValue(sqlEntity.get委託先の機関の区分()).get名称());
        }
        if (sqlEntity.get調査員の性別() != null && !sqlEntity.get調査員の性別().isEmpty()) {
            entity.set調査員の性別(Seibetsu.toValue(sqlEntity.get調査員の性別()).get名称());
        }
        if (sqlEntity.get調査員の調査員資格() != null && !sqlEntity.get調査員の調査員資格().isEmpty()) {
            entity.set調査員の調査員資格(Sikaku.toValue(sqlEntity.get調査員の調査員資格()).get名称());
        }
        if (sqlEntity.get概況特記テキストイメージ区分コード() != null && !sqlEntity.get概況特記テキストイメージ区分コード().isEmpty()) {
            entity.set概況特記テキストイメージ区分(TokkijikoTextImageKubun.toValue(sqlEntity.get概況特記テキストイメージ区分コード()).get名称());
        }
        if (sqlEntity.get認定調査依頼区分コード() != null && !sqlEntity.get認定調査依頼区分コード().isEmpty()) {
            entity.set認定調査依頼区分(NinteiChousaIraiKubunCode.toValue(sqlEntity.get認定調査依頼区分コード()).get名称());
        }
        if (sqlEntity.get認定調査区分コード() != null && !sqlEntity.get認定調査区分コード().isEmpty()) {
            entity.set認定調査区分(ChosaKubun.toValue(sqlEntity.get認定調査区分コード()).get名称());
        }
        if (sqlEntity.get利用施設郵便番号() != null) {
            RString three = sqlEntity.get利用施設郵便番号().substring(ZEOR, THREE);
            RString four = sqlEntity.get利用施設郵便番号().substring(THREE, SEVEN);
            entity.set利用施設郵便番号(three.concat(横木).concat(four));
        }
        if (sqlEntity.get認定調査特記事項受付年月日() != null) {
            entity.set認定調査特記事項受付年月日(sqlEntity.get認定調査特記事項受付年月日().wareki().toDateString());
        }
        entity.set申請書管理番号(sqlEntity.get申請書管理番号());
        entity.set厚労省IF識別コード(sqlEntity.get厚労省IF識別コード());
        entity.set証記載保険者番号(sqlEntity.get証記載保険者番号());
        entity.set認定申請区分申請時コード(sqlEntity.get認定申請区分申請時コード());
        entity.set被保険者氏名(sqlEntity.get被保険者氏名());
        entity.set被保険者氏名カナ(sqlEntity.get被保険者氏名カナ());
        entity.set年齢(sqlEntity.get年齢());
        entity.set住所(sqlEntity.get住所());
        entity.set電話番号(sqlEntity.get電話番号());
        entity.set保険者名(sqlEntity.get保険者名());
        entity.set認定調査依頼履歴番号(sqlEntity.get認定調査依頼履歴番号());
        entity.set認定調査委託先コード(sqlEntity.get認定調査委託先コード());
        entity.set調査委託先(sqlEntity.get調査委託先());
        entity.set委託先の事業者名称カナ(sqlEntity.get委託先の事業者名称カナ());
        entity.set委託先の住所(sqlEntity.get委託先の住所());
        entity.set委託先の電話番号(sqlEntity.get委託先の電話番号());
        entity.set委託先のFAX番号(sqlEntity.get委託先のFAX番号());
        entity.set委託先の代表者名(sqlEntity.get委託先の代表者名());
        entity.set委託先の代表者名カナ(sqlEntity.get委託先の代表者名カナ());
        entity.set委託先の割付定員(sqlEntity.get委託先の割付定員());
        entity.set委託先の特定調査員表示フラグ(sqlEntity.is委託先の特定調査員表示フラグ());
        entity.set委託先の割付定員(sqlEntity.get委託先の割付定員());
        entity.set委託先の割付地区(sqlEntity.get委託先の割付地区());
        entity.set認定調査員コード(sqlEntity.get認定調査員コード());
        entity.set調査員氏名(sqlEntity.get調査員氏名());
        entity.set調査員の調査員氏名カナ(sqlEntity.get調査員の調査員氏名カナ());
        entity.set調査員の地区コード(sqlEntity.get調査員の地区コード());
        entity.set調査員の調査可能人数月(sqlEntity.get調査員の調査可能人数月());
        entity.set調査員の住所(sqlEntity.get調査員の住所());
        entity.set調査員の電話番号(sqlEntity.get調査員の電話番号());
        entity.set調査員のFAX番号(sqlEntity.get調査員のFAX番号());
        entity.set調査員の所属機関名称(sqlEntity.get調査員の所属機関名称());
        entity.set概況特記テキストイメージ区分コード(sqlEntity.get概況特記テキストイメージ区分コード());
        entity.set認定調査依頼区分コード(sqlEntity.get認定調査依頼区分コード());
        entity.set認定調査回数(sqlEntity.get認定調査回数());
        entity.set認定調査区分コード(sqlEntity.get認定調査区分コード());
        entity.set認定調査実施場所コード(sqlEntity.get認定調査実施場所コード());
        entity.set認定調査実施場所名称(sqlEntity.get認定調査実施場所名称());
        entity.set認定調査サービス区分コード(sqlEntity.get認定調査サービス区分コード());
        entity.set利用施設名(sqlEntity.get利用施設名());
        entity.set利用施設住所(sqlEntity.get利用施設住所());
        entity.set利用施設電話番号(sqlEntity.get利用施設電話番号());
        entity.set特記(sqlEntity.get特記());
        entity.set住宅改修改修箇所(sqlEntity.get住宅改修改修箇所());
        entity.set市町村特別給付サービス種類名(sqlEntity.get市町村特別給付サービス種類名());
        entity.set介護保険給付以外の在宅サービス種類名(sqlEntity.get介護保険給付以外の在宅サービス種類名());
        entity.set概況特記事項主訴(sqlEntity.get概況特記事項主訴());
        entity.set概況特記事項家族状況(sqlEntity.get概況特記事項家族状況());
        entity.set概況特記事項居住環境(sqlEntity.get概況特記事項居住環境());
        entity.set概況特記事項機器器械(sqlEntity.get概況特記事項機器器械());
        entity.set認定調査特記事項番号(sqlEntity.get認定調査特記事項番号());
        entity.set認定調査特記事項連番(sqlEntity.get認定調査特記事項連番());
        entity.set原本マスク区分コード(sqlEntity.get原本マスク区分コード());
        entity.set特記事項(sqlEntity.get特記事項());
        entity.setサービスの状況連番(sqlEntity.getサービスの状況連番());
        entity.setサービスの状況(sqlEntity.getサービスの状況());
        entity.setサービスの状況フラグ連番(sqlEntity.getサービスの状況フラグ連番());
        entity.setサービスの状況フラグ(sqlEntity.getサービスの状況フラグ());
        entity.set記入項目連番(sqlEntity.get記入項目連番());
        entity.setサービスの状況記入(sqlEntity.getサービスの状況記入());
        entity.set施設利用連番(sqlEntity.get施設利用連番());
        entity.set施設利用フラグ(sqlEntity.get施設利用フラグ());
        entity.set認定調査認知症高齢者の日常生活自立度コード(sqlEntity.get認定調査認知症高齢者の日常生活自立度コード());
        entity.set認定調査障害高齢者の日常生活自立度コード(sqlEntity.get認定調査障害高齢者の日常生活自立度コード());
        entity.set調査項目連番(sqlEntity.get調査項目連番());
        entity.set内容(sqlEntity.get内容());
    }
    
    /**
     * 受給者台帳情報の追加する
     *
     * @param shinseishoKanriNo RString
     */
    public void insert受給者台帳情報(RString shinseishoKanriNo) {
        IChosaDataMobileMapper mapper = mapperProvider.create(IChosaDataMobileMapper.class);
        DbT4001JukyushaDaichoEntity 受給者台帳情報 = mapper.get受給者台帳情報(shinseishoKanriNo); 
        if (受給者台帳情報 != null) {

            DbT4001JukyushaDaichoEntity 新規受給者台帳情報 = new DbT4001JukyushaDaichoEntity();
            新規受給者台帳情報.setShichosonCode(受給者台帳情報.getShichosonCode());
            新規受給者台帳情報.setHihokenshaNo(受給者台帳情報.getHihokenshaNo());
            新規受給者台帳情報.setRirekiNo(new RString(Integer.parseInt(受給者台帳情報.getRirekiNo().toString()) + 1));
            新規受給者台帳情報.setEdaban(new RString("00"));
            CountedItem countedItem = Saiban.get(SubGyomuCode.DBE認定支援, new RString("申請書管理番号"));
            新規受給者台帳情報.setShinseishoKanriNo(new ShinseishoKanriNo(countedItem.nextString()));
            新規受給者台帳情報.setShinseiJokyoKubun(new RString("9"));
            新規受給者台帳情報.setShishoCode(受給者台帳情報.getShishoCode());
            新規受給者台帳情報.setChokkinFlag(false);
            新規受給者台帳情報.setShikibetsuCode(受給者台帳情報.getShikibetsuCode());
            新規受給者台帳情報.setJukyuShinseiJiyu(new Code("7"));
            新規受給者台帳情報.setYukoMukoKubun(new Code("2"));
            新規受給者台帳情報.setDataKubun(new Code("51"));
            新規受給者台帳情報.setRemban(new RString("0001"));
            新規受給者台帳情報.setYoshienshaNinteiShinseiFlag(false);
            新規受給者台帳情報.setShikakuShutokuMaeShinseiFlag(false);
            新規受給者台帳情報.setKyuSochishaFlag(false);
            新規受給者台帳情報.setLogicalDeletedFlag(false);

            KoshinTaishoManager manger = KoshinTaishoManager.createInstance();
            manger.insertDbt4001johon(新規受給者台帳情報);
        }
    }
}
