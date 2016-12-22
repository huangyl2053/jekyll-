/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosadataoutput;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 概況調査基本調査データ.CSVで出力するためにEntityです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class NinteiChosaBasicDataRelateEntity implements IDbAccessable {

    private NinteiChosaDataOutputBatchRelateEntity 今回分Entity;
    private NinteiChosaDataOutputBatchRelateEntity 前回分Entity;
}
