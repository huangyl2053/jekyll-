/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB241001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb241001.TokuchoHaishinDataTorikomiProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.UzT0885SharedFileEntryEntity;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * バッチ設計_DBB241001_特徴配信データ取り込みのバッチ起動時に設定されるパラメータ
 *
 * @reamsid_L DBB-4270-020 chenyadong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBB241001_TokuchoHaishinDataTorikomiParameter extends BatchParameterBase {

    private static final RString FILTER_Z1A = new RString("Z1%");

    @BatchParameter(key = "sharedFileEntryDescriptorList", name = "sharedFileEntryDescriptorList")
    private List<SharedFileEntryDescriptor> sharedFileEntryDescriptorList;
    @BatchParameter(key = "shoriYMDHM", name = "shoriYMDHM")
    private RDateTime shoriYMDHM;

    /**
     * コンストラクタです
     *
     */
    public DBB241001_TokuchoHaishinDataTorikomiParameter() {
        List<UzT0885SharedFileEntryEntity> ファイル対象List = SharedFile.searchSharedFile(FILTER_Z1A);
        List<SharedFileEntryDescriptor> fileEntryList = new ArrayList<>();
        for (UzT0885SharedFileEntryEntity ファイル対象 : ファイル対象List) {
            SharedFileEntryDescriptor descriptor = SharedFileEntryDescriptor.fromEntity(ファイル対象);
            fileEntryList.add(descriptor);
        }
        this.sharedFileEntryDescriptorList = new ArrayList<>();
        this.sharedFileEntryDescriptorList.addAll(fileEntryList);
    }

    /**
     * processのパラメータを生成します。
     *
     * @param fileName RString
     * @return processパラメータ
     */
    public TokuchoHaishinDataTorikomiProcessParameter toProcessParameter(RString fileName) {
        return new TokuchoHaishinDataTorikomiProcessParameter(fileName, this.shoriYMDHM);
    }
}
