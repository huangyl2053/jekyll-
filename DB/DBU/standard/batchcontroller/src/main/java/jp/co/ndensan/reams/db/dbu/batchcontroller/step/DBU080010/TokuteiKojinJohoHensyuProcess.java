/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU080010;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import jp.co.ndensan.reams.db.dbu.business.core.tokuteikojinjohoteikyo.TokuteiKojinJohoKoumokuHanKanriBusiness;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.BangoseidoKinoShiyoSeigyo;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.MukokaFlag;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.TokuteiKojinJohoKomokuKubun;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.tokuteikojinjohoteikyo.TokuteiKojinJohoHensyuMybatisParamater;
import jp.co.ndensan.reams.db.dbu.definition.processprm.tokuteikojinjohoteikyo.TokuteiKojinJohoHensyuProcessParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo.TeikyoKihonJohoNNTempEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo.TeyikyouNaiyouRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.xml.DBM20113AttachToBsBeanEntity;
import jp.co.ndensan.reams.db.dbu.entity.xml.DBM20113AttachToBsEntity;
import jp.co.ndensan.reams.db.dbu.entity.xml.DBM20113ToBsBeanEntity;
import jp.co.ndensan.reams.db.dbu.entity.xml.DBM20113ToBsEntity;
import jp.co.ndensan.reams.db.dbu.entity.xml.MessageHeaderEntity;
import jp.co.ndensan.reams.db.dbu.service.core.tokuteikojinjohoteikyo.TokuteiKojinJohoTeikyoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.io.FileWriter;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 特定個人情報編集(標準)バッチ処理です。
 *
 * @reamsid_L DBU-4880-100 wangxiaodong
 */
@SuppressWarnings("checkstyle:illegaltoken")
public class TokuteiKojinJohoHensyuProcess extends BatchProcessBase<TeikyoKihonJohoNNTempEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.tokuteikojinjohoteikyo."
            + "ITokuteiKojinJohoHensyuMapper.get中間DB提供基本情報");
    private TokuteiKojinJohoHensyuProcessParameter processParameter;
    private TokuteiKojinJohoHensyuMybatisParamater mybatisParameter;
    private static final int 桁目_6 = 5;
    private static final int 桁目_3 = 2;
    private static final int 桁数_3 = 3;
    private static final RString 換行符 = new RString("\\n");
    private static final RString 転義符 = new RString("\"");
    private static final RString 本番モード = new RString("0");
    private static final RString テストモード = new RString("1");
    private static final RString 登録削除区分 = new RString("1");
    private static final RString 電文種別ID = new RString("IF_DBM_20113_R01");
    private static final RString 文字列_大なり = new RString(">");
    private static final RString 文字列_小なり = new RString("<");
    private static final RString 文字列_二重引用符 = new RString("\"");
    private static final RString 文字列_スラッシュ = new RString("/");
    private static final RString 文字列_連結符 = new RString("_");
    private static final RString 文字列_ハイフン = new RString("-");
    private static final RString 文字列_拡張子 = new RString(".xml");
    private static final RString 文字列_CDATA後 = new RString("]]>");
    private static final RString 文字列_CDATA前 = new RString("<![CDATA[");
    private static final RString 文字列_VERSION = new RString(" Version=");
    private static final RString 文字列_ENCODING = new RString("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
    private static final RString 文字列_TRUE = new RString("true");
    private static final RString 文字列_TIMEANDDATEOFUPDATE = new RString(" TimeAndDateOfUpdate=");
    private static final RString 文字列_REASONOFNULL = new RString("ReasonOfNull=");
    private static final RString 文字列_XSI = new RString(" xsi:nil=");
    private static final RString 文字列_XMLNS = new RString(" xmlns:xsi=");
    private static final RString 文字列_URL = new RString("http://www.w3.org/2001/XMLSchema-instance");
    private static final RString 登録依頼電文ファイル名 = new RString("DBM_20113");
    private static final RString 登録依頼添付電文ファイル名 = new RString("DBM_20113_ATTACH");
    private static final RDate システム日付 = RDate.getNowDate();
    private RString 行政区コード;
    private RString 提供機能使用制御;
    private RString 依頼元部署コード;
    private RString 特定個人情報分割件数;
    private RString ログインユーザＩＤ;
    private RString 電文実行モード;
    private int 添付データ件数;
    private int ファイル連番;
    private int レコード識別番号;
    private RString 送信元システムID;
    private RString 送信先システムID;
    private List<TeyikyouNaiyouRelateEntity> 提供内容;
    private RString 副本データ;
    private RString 識別項目コード;
    private List<TokuteiKojinJohoKoumokuHanKanriBusiness> 項目版管理List;
    private DBM20113AttachToBsEntity dBM20113AttachToBsEntity;
    private List<DBM20113AttachToBsBeanEntity> dBM20113AttachToBsBeanEntityList;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 中間DB提供基本情報;

    @Override
    protected void initialize() {
        識別項目コード = RString.EMPTY;
        添付データ件数 = 0;
        ファイル連番 = -1;
        レコード識別番号 = 0;
        ログインユーザＩＤ = ControlDataHolder.getUserId();
        dBM20113AttachToBsEntity = new DBM20113AttachToBsEntity();
        dBM20113AttachToBsBeanEntityList = new ArrayList();
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (DonyuKeitaiCode.事務広域 == DonyuKeitaiCode.toValue(市町村セキュリティ情報.get導入形態コード().value())) {
            行政区コード = RString.EMPTY;
        } else {
            行政区コード = AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード().value().substring(桁目_3, 桁目_6);
        }
        提供機能使用制御 = DbBusinessConfig.get(ConfigNameDBU.番号制度_提供機能使用制御, システム日付, SubGyomuCode.DBU介護統計報告);
        if (BangoseidoKinoShiyoSeigyo.稼働.getコード().equals(提供機能使用制御)) {
            電文実行モード = 本番モード;
        } else {
            電文実行モード = テストモード;
        }
        依頼元部署コード = DbBusinessConfig.get(ConfigNameDBU.番号制度_依頼元部署コード, システム日付, SubGyomuCode.DBU介護統計報告);
        if (RString.isNullOrEmpty(依頼元部署コード)) {
            依頼元部署コード = GyomuCode.DB介護保険.value();
        }
        特定個人情報分割件数 = DbBusinessConfig.get(ConfigNameDBU.番号制度_特定個人情報分割件数, システム日付, SubGyomuCode.DBU介護統計報告);
        // TODO #108855の回答により、該当箇所はTODOとし、ダミー値を利用しての確認で問題ありません。
        送信元システムID = new RString("K000000001");
        送信先システムID = new RString("T000000001");
        項目版管理List = TokuteiKojinJohoTeikyoManager.createInstance()
                .get項目バージョン(processParameter.get特定個人情報名コード(), processParameter.getデータセット番号(),
                        processParameter.get版番号(), processParameter.get基準日());
        mybatisParameter = TokuteiKojinJohoHensyuMybatisParamater.createParamter中間DB提供基本情報取得_標準(
                転義符.concat(processParameter.get中間DBテーブル名()).concat(転義符), processParameter.get特定個人情報名コード());
        副本データ = 文字列_CDATA前.concat(文字列_ENCODING);
    }

    @Override
    protected void createWriter() {
        中間DB提供基本情報 = new BatchEntityCreatedTempTableWriter(processParameter.get中間DBテーブル名(),
                TeikyoKihonJohoNNTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void process(TeikyoKihonJohoNNTempEntity t) {
        if (Integer.parseInt(特定個人情報分割件数.toString()) <= 添付データ件数) {
            ファイル連番 = ファイル連番 + 1;
            添付データ件数 = 0;
            print電文(登録依頼電文ファイル名, setDBM20113ToBsEntity());
            print電文(登録依頼添付電文ファイル名, dBM20113AttachToBsEntity);
        }
        添付データ件数 = 添付データ件数 + 1;
        レコード識別番号 = レコード識別番号 + 1;
        get提供内容リスト(t);
        for (TokuteiKojinJohoKoumokuHanKanriBusiness business : 項目版管理List) {
            if (TokuteiKojinJohoKomokuKubun.情報HD.getコード().equals(business.get特定個人情報項目区分())) {
                副本データ = 副本データ.concat(文字列_小なり).concat(business.get特定個人情報項目コード()).concat(文字列_大なり);
            } else if (TokuteiKojinJohoKomokuKubun.繰返し項目.getコード().equals(business.get特定個人情報項目区分())) {
                識別項目コード = business.get特定個人情報項目コード();
                副本データ = 副本データ.concat(文字列_小なり).concat(business.get特定個人情報項目コード()).concat(文字列_VERSION).concat(文字列_二重引用符).
                        concat(business.getバージョン情報()).concat(文字列_二重引用符).concat(文字列_TIMEANDDATEOFUPDATE).
                        concat(文字列_二重引用符).concat(getデータ作成日(システム日付)).concat(文字列_二重引用符).concat(文字列_大なり);
            } else if (TokuteiKojinJohoKomokuKubun.日付項目.getコード().equals(business.get特定個人情報項目区分())
                    || TokuteiKojinJohoKomokuKubun.個別項目.getコード().equals(business.get特定個人情報項目区分())) {
                int index = Integer.parseInt(business.get提供内容項目番号().toString()) - 1;
                if (MukokaFlag.有効.getコード().equals(business.get無効化フラグ())) {
                    副本データ = 副本データ.concat(文字列_小なり).concat(business.get特定個人情報項目コード()).concat(文字列_VERSION).
                            concat(文字列_二重引用符).concat(business.getバージョン情報()).concat(文字列_二重引用符);
                }
                if (RString.isNullOrEmpty(提供内容.get(index).get提供内容())) {
                    副本データ = 副本データ.concat(文字列_REASONOFNULL).concat(文字列_二重引用符).concat(提供内容.get(index).get未設定事由()).
                            concat(文字列_二重引用符).concat(文字列_XSI).concat(文字列_二重引用符).concat(文字列_TRUE).
                            concat(文字列_二重引用符).concat(文字列_XMLNS).concat(文字列_二重引用符).concat(文字列_URL).
                            concat(文字列_二重引用符).concat(文字列_スラッシュ).concat(文字列_大なり);
                } else {
                    get副本データ(提供内容.get(index).get提供内容(), business.get特定個人情報項目区分(), business.get特定個人情報項目コード());
                }
            }
        }
        for (int i = 項目版管理List.size() - 1; i >= 0; i--) {
            if (TokuteiKojinJohoKomokuKubun.繰返し項目.getコード().equals(項目版管理List.get(i).get特定個人情報項目区分())
                    || TokuteiKojinJohoKomokuKubun.情報HD.getコード().equals(項目版管理List.get(i).get特定個人情報項目区分())) {
                副本データ = 副本データ.concat(文字列_小なり).concat(文字列_スラッシュ).concat(
                        項目版管理List.get(i).get特定個人情報項目コード()).concat(文字列_大なり);
            }
        }
        if (!副本データ.contains(文字列_CDATA後)) {
            副本データ = 副本データ.concat(文字列_CDATA後);
        }
        setDBM20113AttachToBsEntityList(t);
        if (添付データ件数 != 0) {
            ファイル連番 = ファイル連番 + 1;
            print電文(登録依頼電文ファイル名, setDBM20113ToBsEntity());
            print電文(登録依頼添付電文ファイル名, dBM20113AttachToBsEntity);
        }
        中間DB提供基本情報.delete(t);
    }

    private RString getデータ作成日(RDate date) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(date.getYearValue());
        builder.append(文字列_ハイフン);
        builder.append(new RString(date.getMonthValue()).padZeroToLeft(2));
        builder.append(文字列_ハイフン);
        builder.append(new RString(date.getDayValue()).padZeroToLeft(2));
        return builder.toRString();
    }

    private void setDBM20113AttachToBsEntityList(TeikyoKihonJohoNNTempEntity t) {
        DBM20113AttachToBsBeanEntity entity = new DBM20113AttachToBsBeanEntity();
        entity.setSystemShikibetsuCode(RString.EMPTY.toString());
        entity.setShikibetsuCode(RString.EMPTY.toString());
        entity.setKojinNo(t.getKojinNo().toString());
        entity.setRecordIdentificationNumber(new RString(レコード識別番号).toString());
        entity.setIntegratedAddressNumber(RString.EMPTY.toString());
        entity.setSpecificPersonalInformationCode(processParameter.get特定個人情報名コード().toString());
        entity.setDataSetIdentificationItemCode(識別項目コード.toString());
        entity.setDataSetRecordKey(t.getDataSetKey().toString());
        entity.setSPIMajorVersion(processParameter.get版番号().toString());
        entity.setPublicationDate(getデータ作成日(システム日付).toString());
        entity.setPublishedEndDate(RString.EMPTY.toString());
        entity.setAdministrativeRegionCode(行政区コード.toString());
        entity.setDuplicateCopyData(副本データ.toString());
        dBM20113AttachToBsBeanEntityList.add(entity);
        dBM20113AttachToBsEntity.setInformationOfSPIRegistrationDelete(dBM20113AttachToBsBeanEntityList);
        dBM20113AttachToBsEntity.setSegmentOfRegistrationDelete(登録削除区分.toString());
    }

    private MessageHeaderEntity setMessageHeaderEntity() {
        MessageHeaderEntity entity = new MessageHeaderEntity();
        entity.setMsgId(RString.EMPTY.toString());
        entity.setMsgTypeId(電文種別ID.toString());
        entity.setMsgMode(電文実行モード.toString());
        entity.setSourceSystemID(送信元システムID.toString());
        entity.setDestinationSystemID(送信先システムID.toString());
        entity.setMsgResult(RString.EMPTY.toString());
        return entity;
    }

    private DBM20113ToBsBeanEntity setDBM20113ToBsBeanEntity() {
        DBM20113ToBsBeanEntity entity = new DBM20113ToBsBeanEntity();
        entity.setRequestSourceUnitCode(依頼元部署コード.toString());
        entity.setRequestSourceUserID(ログインユーザＩＤ.toString());
        return entity;
    }

    private DBM20113ToBsEntity setDBM20113ToBsEntity() {
        DBM20113ToBsEntity entity = new DBM20113ToBsEntity();
        entity.setMessageHeader(setMessageHeaderEntity());
        entity.setMessageBody(setDBM20113ToBsBeanEntity());
        return entity;
    }

    private void get副本データ(RString 提供内容, RString 特定個人情報項目区分, RString 特定個人情報項目コード) {
        if (TokuteiKojinJohoKomokuKubun.日付項目.getコード().equals(特定個人情報項目区分)) {
            副本データ.concat(文字列_大なり).concat(getデータ作成日(new RDate(提供内容.toString()))).concat(文字列_小なり).
                    concat(文字列_スラッシュ).concat(特定個人情報項目コード).concat(文字列_大なり);
        } else {
            副本データ.concat(文字列_大なり).concat(提供内容).concat(文字列_小なり).
                    concat(文字列_スラッシュ).concat(特定個人情報項目コード).concat(文字列_大なり);
        }
    }

    private void get提供内容リスト(TeikyoKihonJohoNNTempEntity t) {
        提供内容 = new ArrayList();
        TeyikyouNaiyouRelateEntity entity = new TeyikyouNaiyouRelateEntity();
        entity.set提供内容(t.getTeikyoNaiyo01());
        entity.set未設定事由(t.getMisetteiJiyu01());
        提供内容.add(entity);
        entity = new TeyikyouNaiyouRelateEntity();
        entity.set提供内容(t.getTeikyoNaiyo02());
        entity.set未設定事由(t.getMisetteiJiyu02());
        提供内容.add(entity);
        entity = new TeyikyouNaiyouRelateEntity();
        entity.set提供内容(t.getTeikyoNaiyo03());
        entity.set未設定事由(t.getMisetteiJiyu03());
        提供内容.add(entity);
        entity = new TeyikyouNaiyouRelateEntity();
        entity.set提供内容(t.getTeikyoNaiyo04());
        entity.set未設定事由(t.getMisetteiJiyu04());
        提供内容.add(entity);
        entity = new TeyikyouNaiyouRelateEntity();
        entity.set提供内容(t.getTeikyoNaiyo05());
        entity.set未設定事由(t.getMisetteiJiyu05());
        提供内容.add(entity);
        entity = new TeyikyouNaiyouRelateEntity();
        entity.set提供内容(t.getTeikyoNaiyo06());
        entity.set未設定事由(t.getMisetteiJiyu06());
        提供内容.add(entity);
        entity = new TeyikyouNaiyouRelateEntity();
        entity.set提供内容(t.getTeikyoNaiyo07());
        entity.set未設定事由(t.getMisetteiJiyu07());
        提供内容.add(entity);
        entity = new TeyikyouNaiyouRelateEntity();
        entity.set提供内容(t.getTeikyoNaiyo08());
        entity.set未設定事由(t.getMisetteiJiyu08());
        提供内容.add(entity);
        entity = new TeyikyouNaiyouRelateEntity();
        entity.set提供内容(t.getTeikyoNaiyo09());
        entity.set未設定事由(t.getMisetteiJiyu09());
        提供内容.add(entity);
        entity = new TeyikyouNaiyouRelateEntity();
        entity.set提供内容(t.getTeikyoNaiyo10());
        entity.set未設定事由(t.getMisetteiJiyu10());
        提供内容.add(entity);
    }

    private RString get電文ファイル名(RString name) {
        return Path.combinePath(Path.getTmpDirectoryPath(), name.concat(文字列_連結符).concat(processParameter.get特定個人情報名コード()).
                concat(文字列_連結符).concat(送信先システムID).concat(文字列_連結符).concat(processParameter.getデータセット番号()).
                concat(文字列_連結符).concat(new RString(ファイル連番).padZeroToLeft(桁数_3)).concat(文字列_拡張子));
    }

    private void print電文(RString ファイル名, Object jaxbElement) {
        try {
            JAXBContext context = JAXBContext.newInstance(jaxbElement.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, com.fasterxml.jackson.core.JsonEncoding.UTF8.getJavaName());
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);
            marshaller.setProperty(com.sun.xml.bind.marshaller.CharacterEscapeHandler.class.getName(),
                    new com.sun.xml.bind.marshaller.CharacterEscapeHandler() {
                        @Override
                        public void escape(char[] ac, int i, int j, boolean flag, java.io.Writer writer) throws IOException {
                            writer.write(ac, i, j);
                        }
                    });
            java.io.StringWriter writer = new StringWriter();
            marshaller.marshal(jaxbElement, writer);
            RString strXml = new RString(writer.toString());
            List<RString> listStr = strXml.split(換行符.toString());
            try (FileWriter fileWriter = new FileWriter(get電文ファイル名(ファイル名))) {
                for (RString rString : listStr) {
                    fileWriter.writeLine(rString);
                }
                fileWriter.close();
            }
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

}
